package com.example.ejercicio2.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=120)
    private String titulo;

    @Column(nullable = false, length=100)
    private String autor;

    @Column(name = "anio_publicacion", nullable = false)
    private int anioPublicacion;  // <- corregido: a minúscula

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonBackReference
    private Categoria categoria;

    // Constructor vacío requerido por JPA
    public Libro() {
    }

    // @JsonCreator: le dice a Jackson que use este constructor para deserializar el JSON.
    // @JsonProperty: mapea cada campo del JSON al parámetro correspondiente del constructor.
    @JsonCreator
    public Libro(@JsonProperty("id") Long id,
                 @JsonProperty("titulo") String titulo,
                 @JsonProperty("autor") String autor,
                 @JsonProperty("anioPublicacion") int anioPublicacion,
                 @JsonProperty("categoria") Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;  // <- corregido
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;  // <- corregido
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;  // <- corregido
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +  // <- corregido
                ", categoria=" + categoria +
                '}';
    }
}