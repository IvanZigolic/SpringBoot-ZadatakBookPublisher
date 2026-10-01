package com.example.ZadatakBookPublisher.repository;

import com.example.ZadatakBookPublisher.domain.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public interface SpringDataBookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}
