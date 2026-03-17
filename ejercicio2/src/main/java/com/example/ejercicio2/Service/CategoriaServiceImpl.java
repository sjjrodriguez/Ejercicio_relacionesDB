package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Categoria;
import com.example.ejercicio2.Repository.CategoriaRepository;
import com.example.ejercicio2.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        return categoriaRepository.findById(id).map(c -> {
            c.setNombre(categoria.getNombre());
            c.setDescripcion(categoria.getDescripcion());
            return categoriaRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("No encontrada: " + id));
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}