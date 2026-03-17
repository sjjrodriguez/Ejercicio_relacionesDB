package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Curso;
import com.example.ejercicio2.Repository.CursoRepository;
import com.example.ejercicio2.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {


    private CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Long id, Curso curso) {
        return cursoRepository.findById(id).map(c -> {
            c.setNombre(curso.getNombre());
            c.setCreditos(curso.getCreditos());
            return cursoRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("No encontrado: " + id));
    }

    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}