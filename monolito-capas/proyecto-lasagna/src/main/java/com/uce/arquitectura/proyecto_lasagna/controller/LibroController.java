package com.uce.arquitectura.proyecto_lasagna.controller;

import com.uce.arquitectura.proyecto_lasagna.model.Libro;
import com.uce.arquitectura.proyecto_lasagna.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listarTodos());
        return "libros";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro) {
        boolean exito = service.guardarConValidacion(libro);
        if (!exito) {
            return "redirect:/libros?error=true";
        }
        return "redirect:/libros";
    }
}