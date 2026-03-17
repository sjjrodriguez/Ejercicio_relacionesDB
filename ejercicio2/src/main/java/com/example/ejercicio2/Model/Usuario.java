package com.example.ejercicio2.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=80)
    private String nombre;

    @Column(nullable=false, length=120)
    private String correo;

    @OneToOne(mappedBy ="usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("usuario")
    private PerfilUsuario perfil;

    // Constructor vacío requerido por JPA
    public Usuario() {
    }

    // @JsonCreator: le dice a Jackson que use este constructor para deserializar el JSON.
    // @JsonProperty: mapea cada campo del JSON al parámetro correspondiente del constructor.
    @JsonCreator
    public Usuario(@JsonProperty("id") Long id,
                   @JsonProperty("nombre") String nombre,
                   @JsonProperty("correo") String correo,
                   @JsonProperty("perfil") PerfilUsuario perfil) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}