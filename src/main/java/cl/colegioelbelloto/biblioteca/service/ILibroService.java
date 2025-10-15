package cl.colegioelbelloto.biblioteca.service;

import cl.colegioelbelloto.biblioteca.model.Libro;

import java.util.List;

public interface ILibroService {

    Libro saveLibro(Libro libro);

    List<Libro> AllLibros();

    Libro updateLibro(Long idLibro);

    void deleteLibro(Long idLibro);

}
