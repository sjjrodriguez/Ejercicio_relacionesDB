package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Libro;
import com.example.ejercicio2.Repository.LibroRepository;
import com.example.ejercicio2.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {


    private LibroRepository librosRepository;

    public LibroServiceImpl(LibroRepository librosRepository) {
        this.librosRepository = librosRepository;
    }

    @Override
    public List<Libro> findAll() {
        return librosRepository.findAll();
    }

    @Override
    public Libro save(Libro libro) {
        return librosRepository.save(libro);
    }

    @Override
    public Libro update(Long id, Libro libro) {
        return librosRepository.findById(id).map(l -> {
            l.setTitulo(libro.getTitulo());
            l.setAutor(libro.getAutor());
            l.setAnioPublicacion(libro.getAnioPublicacion());
            l.setCategoria(libro.getCategoria());
            return librosRepository.save(l);
        }).orElseThrow(() -> new RuntimeException("No encontrado: " + id));
    }

    @Override
    public void deleteById(Long id) {
        librosRepository.deleteById(id);
    }
}