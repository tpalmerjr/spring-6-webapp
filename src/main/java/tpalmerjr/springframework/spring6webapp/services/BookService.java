package tpalmerjr.springframework.spring6webapp.services;

import tpalmerjr.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
