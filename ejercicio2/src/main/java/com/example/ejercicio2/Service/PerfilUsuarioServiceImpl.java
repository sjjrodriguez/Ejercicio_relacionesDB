package com.example.ejercicio2.Service;

import com.example.ejercicio2.Model.PerfilUsuario;
import com.example.ejercicio2.Model.Usuario;
import com.example.ejercicio2.Repository.PerfilUsuarioRepository;
import com.example.ejercicio2.Repository.UsuarioRepository;
import com.example.ejercicio2.Service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {


    private PerfilUsuarioRepository perfilRepository;


    private UsuarioRepository usuarioRepository;

    public PerfilUsuarioServiceImpl(PerfilUsuarioRepository perfilRepository, UsuarioRepository usuarioRepository) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<PerfilUsuario> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public PerfilUsuario save(PerfilUsuario perfil) {
        Usuario usuario = usuarioRepository.findById(perfil.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + perfil.getUsuario().getId()));
        perfil.setUsuario(usuario);
        return perfilRepository.save(perfil);
    }

    @Override
    public PerfilUsuario update(Long id, PerfilUsuario perfil) {
        return perfilRepository.findById(id).map(p -> {
            Usuario usuario = usuarioRepository.findById(perfil.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + perfil.getUsuario().getId()));
            p.setDocumento(perfil.getDocumento());
            p.setTelefono(perfil.getTelefono());
            p.setUsuario(usuario);
            return perfilRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Perfil no encontrado con id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        perfilRepository.deleteById(id);
    }
}