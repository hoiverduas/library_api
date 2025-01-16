package com.javaDv.library_api.controller;


import com.javaDv.library_api.entities.Book;
import com.javaDv.library_api.exception.BookNotFound;
import com.javaDv.library_api.service.impl.Bookservice;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")

public class BookController {

    private final Bookservice bookservice;

    public BookController(Bookservice bookservice) {
        this.bookservice = bookservice;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book, BindingResult result){

        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            throw new ValidationException("Error : " + errorMessage);
        }

       try {
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(this.bookservice.createBook(book));
       }catch (RuntimeException e){

           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST).build();
       }

    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.bookservice.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) throws BookNotFound {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.bookservice.findBookById(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Book> updateBook(@PathVariable Long id ,@RequestBody Book book) throws BookNotFound {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.bookservice.updateBook(id,book));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id) throws BookNotFound {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.bookservice.deleteBook(id));
    }

}
