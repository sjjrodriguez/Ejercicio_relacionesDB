package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Usuario update(Long id, Usuario usuario);
    void deleteById(Long id);
}