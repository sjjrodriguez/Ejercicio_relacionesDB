package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> findAll();
    Libro save(Libro libro);
    Libro update(Long id, Libro libro);
    void deleteById(Long id);
}