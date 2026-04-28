package com.uce.arquitectura.proyecto_lasagna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Integer anio;

    // El constructor vacío es obligatorio para que JPA no llore
    public Libro() {}

    public Libro(String titulo, String autor, Integer anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    // Getters y Setters (Fundamentales para que el HTML los vea)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
}