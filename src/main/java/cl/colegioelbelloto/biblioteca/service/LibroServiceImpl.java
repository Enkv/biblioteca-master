package cl.colegioelbelloto.biblioteca.service;

import cl.colegioelbelloto.biblioteca.model.Libro;
import cl.colegioelbelloto.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class LibroServiceImpl implements ILibroService{

    @Autowired
    LibroRepository libroRepository;

    @Override
    public Libro saveLibro(Libro libro) {
        libroRepository.save(libro);
        return libro;
    }

    @Override
    public List<Libro> AllLibros() {

        return List.of();
    }

    @Override
    public Libro updateLibro(Long idLibro) {

        return null;
    }

    @Override
    public void deleteLibro(Long idLibro) {

    }
}
