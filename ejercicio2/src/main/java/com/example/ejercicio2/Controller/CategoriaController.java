package com.example.ejercicio2.Controller;

import com.example.ejercicio2.Model.Categoria;
import com.example.ejercicio2.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {


    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // SQL: SELECT * FROM categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    // SQL: INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)
    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    // SQL: UPDATE categorias SET nombre=?, descripcion=? WHERE id=?
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.update(id, categoria));
    }

    // SQL: DELETE FROM categorias WHERE id=?
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}