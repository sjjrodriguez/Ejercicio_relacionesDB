package com.example.ejercicio2.Controller;

import com.example.ejercicio2.Model.Libro;
import com.example.ejercicio2.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {


    private final  LibroService librosService;

    public LibroController(LibroService librosService) {
        this.librosService = librosService;
    }

    // SQL: SELECT * FROM libros
    @GetMapping
    public ResponseEntity<List<Libro>> findAll() {
        return ResponseEntity.ok(librosService.findAll());
    }

    // SQL: INSERT INTO libros (titulo, autor, anio_publicacion, categoria_id) VALUES (?, ?, ?, ?)
    @PostMapping
    public ResponseEntity<Libro> save(@RequestBody Libro  libro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(librosService.save(libro));
    }

    // SQL: UPDATE libros SET titulo=?, autor=?, anio_publicacion=?, categoria_id=? WHERE id=?
    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable Long id, @RequestBody Libro libro) {
        return ResponseEntity.ok(librosService.update(id, libro));
    }

    // SQL: DELETE FROM libros WHERE id=?
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        librosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}