package com.example.ejercicio2.Repository;

import com.example.ejercicio2.Model.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {}