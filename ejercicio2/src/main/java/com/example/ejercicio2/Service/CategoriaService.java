package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> findAll();
    Categoria save(Categoria categoria);
    Categoria update(Long id, Categoria categoria);
    void deleteById(Long id);
}