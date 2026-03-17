package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Curso;
import com.example.ejercicio2.Model.Estudiante;
import com.example.ejercicio2.Repository.CursoRepository;
import com.example.ejercicio2.Repository.EstudianteRepository;
import com.example.ejercicio2.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EstudianteServiceImpl implements EstudianteService {


    private EstudianteRepository estudianteRepository;

    private CursoRepository cursoRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository, CursoRepository cursoRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getCursos() != null && !estudiante.getCursos().isEmpty()) {
            Set<Curso> cursos = new HashSet<>();
            for (Curso curso : estudiante.getCursos()) {
                Curso cursoReal = cursoRepository.findById(curso.getId())
                        .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + curso.getId()));
                cursos.add(cursoReal);
            }
            estudiante.setCursos(cursos);
        } else {
            estudiante.setCursos(new HashSet<>());
        }
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Long id, Estudiante estudiante) {
        return estudianteRepository.findById(id).map(e -> {
            if (estudiante.getCursos() != null && !estudiante.getCursos().isEmpty()) {
                Set<Curso> cursos = new HashSet<>();
                for (Curso curso : estudiante.getCursos()) {
                    Curso cursoReal = cursoRepository.findById(curso.getId())
                            .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + curso.getId()));
                    cursos.add(cursoReal);
                }
                e.setCursos(cursos);
            } else {
                e.setCursos(new HashSet<>());
            }
            e.setNombre(estudiante.getNombre());
            e.setCorreo(estudiante.getCorreo());
            return estudianteRepository.save(e);
        }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }
}