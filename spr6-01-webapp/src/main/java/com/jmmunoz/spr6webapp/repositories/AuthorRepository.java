package com.jmmunoz.spr6webapp.repositories;

import com.jmmunoz.spr6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

// No necesitamos implementar el código del repositorio.
// Va a ser reconocido como un componente Spring y Spring Data JPA va a generar
// la implementación del código en tiempo de ejecución.
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
