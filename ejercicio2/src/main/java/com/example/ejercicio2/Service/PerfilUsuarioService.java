package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.PerfilUsuario;
import java.util.List;

public interface PerfilUsuarioService {
    List<PerfilUsuario> findAll();
    PerfilUsuario save(PerfilUsuario perfil);
    PerfilUsuario update(Long id, PerfilUsuario perfil);
    void deleteById(Long id);
}