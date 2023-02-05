package com.jmmunoz.spr6webapp.services;

import com.jmmunoz.spr6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
