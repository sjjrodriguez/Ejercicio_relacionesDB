package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Estudiante;
import java.util.List;

public interface EstudianteService {
    List<Estudiante> findAll();
    Estudiante save(Estudiante estudiante);
    Estudiante update(Long id, Estudiante estudiante);
    void deleteById(Long id);
}