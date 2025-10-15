package cl.colegioelbelloto.biblioteca.repository;

import cl.colegioelbelloto.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
