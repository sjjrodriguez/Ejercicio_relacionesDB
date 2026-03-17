package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Curso;
import java.util.List;

public interface CursoService {
    List<Curso> findAll();
    Curso save(Curso curso);
    Curso update(Long id, Curso curso);
    void deleteById(Long id);
}