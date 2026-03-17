package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.Usuario;
import com.example.ejercicio2.Repository.UsuarioRepository;
import com.example.ejercicio2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombre(usuario.getNombre());
            u.setCorreo(usuario.getCorreo());
            return usuarioRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("No encontrado: " + id));
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}