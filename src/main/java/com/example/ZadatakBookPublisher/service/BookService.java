package com.example.ZadatakBookPublisher.service;

import com.example.ZadatakBookPublisher.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> getAllBooks();
    Optional<BookDTO> findByIsbn(String isbn);
    BookDTO saveNewBook(BookDTO bookDTO);
    Optional<BookDTO> update(String isbn, BookDTO updatedBookDTO);
    void delete(String isbn);
}
