package com.javaDv.library_api.repository;

import com.javaDv.library_api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
}
