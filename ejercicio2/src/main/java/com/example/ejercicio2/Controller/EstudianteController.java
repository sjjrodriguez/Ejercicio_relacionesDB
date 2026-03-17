package com.example.ejercicio2.Controller;

import com.example.ejercicio2.Model.Estudiante;
import com.example.ejercicio2.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {


    private EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // SQL: SELECT * FROM estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>> findAll() {
        return ResponseEntity.ok(estudianteService.findAll());
    }

    // SQL: INSERT INTO estudiantes (nombre, correo) VALUES (?, ?)
    //      INSERT INTO estudiante_curso (estudiante_id, curso_id) VALUES (?, ?)
    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.save(estudiante));
    }

    // SQL: UPDATE estudiantes SET nombre=?, correo=? WHERE id=?
    //      DELETE FROM estudiante_curso WHERE estudiante_id=?
    //      INSERT INTO estudiante_curso (estudiante_id, curso_id) VALUES (?, ?)
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.update(id, estudiante));
    }

    // SQL: DELETE FROM estudiante_curso WHERE estudiante_id=?
    //      DELETE FROM estudiantes WHERE id=?
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        estudianteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}