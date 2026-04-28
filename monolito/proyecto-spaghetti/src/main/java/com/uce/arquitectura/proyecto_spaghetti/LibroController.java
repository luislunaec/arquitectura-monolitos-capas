package com.uce.arquitectura.proyecto_spaghetti;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final ChatLanguageModel chatLanguageModel;
    // Lista en memoria para el Spaghetti (Pecado: No usar DB real)
    private static List<Map<String, Object>> libros = new ArrayList<>();

    public LibroController(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", libros);
        return "libros";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam String titulo,
                          @RequestParam String autor,
                          @RequestParam Integer anio) {

        // --- SPAGHETTI LOGIC CON IA ---
        // Le preguntamos a Gemini si el libro es "serio" para la UCE
        String prompt = "Responde solo con SI o NO. ¿Es el libro '" + titulo + "' de " + autor +
                " un libro que por su nombre este orientado para el crecimiento personal o a la informatica, tal vez para aprender algun lenguaje de programacion, base de datos, etc.?";

        String respuestaIA = chatLanguageModel.generate(prompt);
        System.out.println("🤖 Gemini dice: " + respuestaIA);

        // Si la IA se pone ruda o el año es del futuro, rechazamos
        if (respuestaIA.toUpperCase().contains("NO") || anio > 2026) {
            return "redirect:/libros?error=true";
        }

        // Guardamos directamente en la lista (Arquitectura Nivel: Fideo)
        Map<String, Object> nuevoLibro = new HashMap<>();
        nuevoLibro.put("titulo", titulo);
        nuevoLibro.put("autor", autor);
        nuevoLibro.put("anio", anio);
        libros.add(nuevoLibro);

        return "redirect:/libros";
    }
}