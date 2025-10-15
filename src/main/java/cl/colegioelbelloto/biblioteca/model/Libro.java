package cl.colegioelbelloto.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ⚡ genera el ID en la BD
    private Long idLibro;
    @NonNull
    private String titulo;
    @NonNull
    private String autor;
    @NonNull
    @Column(unique = true) // para que no se repitan
    private String isbn;
    private Integer anioPublicacion;
    private Integer stock;

    public Libro(Long idLibro, String titulo, String autor, String isbn, Integer anioPublicacion, Integer stock) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.stock = stock;
    }

    public Libro(){

    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
