package com.javaDv.library_api.service.impl;


import com.javaDv.library_api.entities.Book;
import com.javaDv.library_api.entities.Status;
import com.javaDv.library_api.exception.BookNotFound;
import com.javaDv.library_api.repository.IBookRepository;
import com.javaDv.library_api.service.IBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Bookservice implements IBookService {


    private final IBookRepository bookRepository;


    public Bookservice(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static   String MESSAGE = "El libro fue eliminado exitosamente  id : ";
    public static   String NOT_FOUND = "El libro no se encuentra disponible  id : ";

    @Override
    public Book createBook(Book book) {
        book.setStatus(Status.AVAILABLE);
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) throws BookNotFound {
        return this.bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFound(NOT_FOUND + id));
    }

    @Override()
    public Book updateBook(Long id,Book book) throws BookNotFound {

        Optional<Book> bookOptional = this.bookRepository.findById(id);

        if (bookOptional.isPresent()){

            Book bookExist = bookOptional.get();

            bookExist.setTitle(book.getTitle());
            bookExist.setStatus(book.getStatus());
            bookExist.setPublishedData(book.getPublishedData());
            bookExist.setIsbn(book.getIsbn());
            bookExist.setAuthor(book.getAuthor());

            return this.bookRepository.save(bookExist);

        }else {
            throw new BookNotFound(NOT_FOUND + id);
        }

    }

    @Override
    public String deleteBook(Long id) throws BookNotFound {
        findBookById(id);
        this.bookRepository.deleteById(id);

        return MESSAGE + id;
    }
}
