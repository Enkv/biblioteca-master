package cl.colegioelbelloto.biblioteca.repository;

import cl.colegioelbelloto.biblioteca.model.Libro;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    //SELECT * FROM Libro WHERE Libro.id=?
    @Override
    Optional<Libro> findById(Long id);
}
// repository se conecta a la base de datos y hace las consultas, viene con metodos listos para utilizar
