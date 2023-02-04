package com.jmmunoz.spr6webapp.services;

import com.jmmunoz.spr6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
