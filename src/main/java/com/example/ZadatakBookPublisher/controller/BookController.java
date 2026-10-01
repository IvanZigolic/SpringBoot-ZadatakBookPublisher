package com.example.ZadatakBookPublisher.controller;

import com.example.ZadatakBookPublisher.domain.Book;
import com.example.ZadatakBookPublisher.dto.BookDTO;
import com.example.ZadatakBookPublisher.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks().stream().toList());
    }
    @GetMapping("/{isbn}")
    public ResponseEntity<List<BookDTO>> findByIsbn(@PathVariable String isbn){
        return ResponseEntity.ok(bookService.findByIsbn(isbn).stream().toList());
    }
    @PostMapping("/new")
    public ResponseEntity<?> saveNewBook(@Valid @RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.saveNewBook(bookDTO));
    }
    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDTO> update(@PathVariable String isbn, @RequestBody BookDTO bookDTO){
        return ResponseEntity.of(bookService.update(isbn, bookDTO));
    }
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> delete(@PathVariable String isbn) {
        if (bookService.findByIsbn(isbn).isPresent()) {
            bookService.delete(isbn);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
