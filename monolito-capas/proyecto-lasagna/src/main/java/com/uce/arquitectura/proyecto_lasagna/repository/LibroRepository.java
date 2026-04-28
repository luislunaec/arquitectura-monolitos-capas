package com.uce.arquitectura.proyecto_lasagna.repository;

import com.uce.arquitectura.proyecto_lasagna.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Aquí no escribimos nada, Spring se encarga de todo el SQL
}