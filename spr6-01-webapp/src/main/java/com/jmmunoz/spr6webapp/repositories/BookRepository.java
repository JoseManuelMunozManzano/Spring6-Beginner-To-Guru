package com.jmmunoz.spr6webapp.repositories;

import com.jmmunoz.spr6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
