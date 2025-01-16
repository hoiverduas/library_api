package com.javaDv.library_api.service;

import com.javaDv.library_api.entities.Book;
import com.javaDv.library_api.exception.BookNotFound;

import java.util.List;

public interface IBookService {

    Book createBook(Book book);
    List<Book> findAllBooks();
    Book findBookById(Long id) throws BookNotFound;
    Book updateBook(Long id,Book book) throws BookNotFound;
    String deleteBook(Long id) throws BookNotFound;

}
