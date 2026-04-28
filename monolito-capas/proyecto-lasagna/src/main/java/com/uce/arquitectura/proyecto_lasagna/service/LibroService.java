package com.uce.arquitectura.proyecto_lasagna.service;

import com.uce.arquitectura.proyecto_lasagna.model.Libro;
import com.uce.arquitectura.proyecto_lasagna.repository.LibroRepository;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {

    private final LibroRepository repository;
    private final ChatLanguageModel chatModel;

    public LibroService(LibroRepository repository, ChatLanguageModel chatModel) {
        this.repository = repository;
        this.chatModel = chatModel;
    }

    public List<Libro> listarTodos() {
        return repository.findAll();
    }

    public boolean guardarConValidacion(Libro libro) {
        // Le preguntamos a Gemini
        String prompt = "Responde solo SI o NO. ¿El libro '" + libro.getTitulo() +
                "' tiene temática académica, técnica o científica?";

        String respuestaIA = chatModel.chat(prompt);
        System.out.println("🤖 Gemini dice: " + respuestaIA);

        // Si la IA aprueba y el año es coherente, guardamos en la DB
        if (respuestaIA.toUpperCase().contains("SI") && libro.getAnio() <= 2026) {
            repository.save(libro);
            return true;
        }
        return false;
    }
}