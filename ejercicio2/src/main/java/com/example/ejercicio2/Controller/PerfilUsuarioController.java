package com.example.ejercicio2.Controller;

import com.example.ejercicio2.Model.PerfilUsuario;
import com.example.ejercicio2.Service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilUsuarioController {


    private PerfilUsuarioService perfilService;

    public PerfilUsuarioController(PerfilUsuarioService perfilService) {
        this.perfilService = perfilService;
    }

    // SQL: SELECT * FROM perfiles_usuario
    @GetMapping
    public ResponseEntity<List<PerfilUsuario>> findAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }

    // SQL: INSERT INTO perfiles_usuario (documento, telefono, usuario_id) VALUES (?, ?, ?)
    @PostMapping
    public ResponseEntity<PerfilUsuario> save(@RequestBody PerfilUsuario perfil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.save(perfil));
    }

    // SQL: UPDATE perfiles_usuario SET documento=?, telefono=?, usuario_id=? WHERE id=?
    @PutMapping("/{id}")
    public ResponseEntity<PerfilUsuario> update(@PathVariable Long id, @RequestBody PerfilUsuario perfil) {
        return ResponseEntity.ok(perfilService.update(id, perfil));
    }

    // SQL: DELETE FROM perfiles_usuario WHERE id=?
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        perfilService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}