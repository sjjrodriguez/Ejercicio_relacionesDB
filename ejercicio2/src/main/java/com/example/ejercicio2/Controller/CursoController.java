package com.example.ejercicio2.Controller;

import com.example.ejercicio2.Model.Curso;
import com.example.ejercicio2.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {


    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // SQL: SELECT * FROM cursos
    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    // SQL: INSERT INTO cursos (nombre, creditos) VALUES (?, ?)
    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }

    // SQL: UPDATE cursos SET nombre=?, creditos=? WHERE id=?
    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.update(id, curso));
    }

    // SQL: DELETE FROM cursos WHERE id=?
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}