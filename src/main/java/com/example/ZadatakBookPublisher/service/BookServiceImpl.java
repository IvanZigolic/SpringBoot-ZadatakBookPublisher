package com.example.ZadatakBookPublisher.service;

import com.example.ZadatakBookPublisher.domain.Book;
import com.example.ZadatakBookPublisher.domain.Publisher;
import com.example.ZadatakBookPublisher.dto.BookDTO;
import com.example.ZadatakBookPublisher.repository.SpringDataBookRepository;
import com.example.ZadatakBookPublisher.repository.SpringDataPublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private SpringDataBookRepository bookRepository;
    private SpringDataPublisherRepository publisherRepository;

    @Override
    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll().stream().map(this::convertToDTO).toList();
    }
    @Override
    public Optional<BookDTO> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).map(this::convertToDTO);
    }
    public BookDTO convertToDTO(Book book){
        return new BookDTO(book);
    }
    public Book convertToBook(BookDTO bookDTO){
        return new Book(null, bookDTO.getTitle(), bookDTO.getIsbn(), bookDTO.getPages(), bookDTO.getPrice(), publisherRepository.findByName(bookDTO.getPublisher()));
    }
    public BookDTO saveNewBook(BookDTO bookDTO){
        return convertToDTO(bookRepository.save(convertToBook(bookDTO)));
    }
    @Override
    public Optional<BookDTO> update(String isbn, BookDTO updatedBookDTO) {
        return bookRepository.findByIsbn(isbn).map(book -> {
            book.setTitle(updatedBookDTO.getTitle());
            book.setPages(updatedBookDTO.getPages());
            book.setPrice(updatedBookDTO.getPrice());
            book.setPublisher(publisherRepository.findByName(updatedBookDTO.getPublisher()));
            return convertToDTO(bookRepository.save(book));
        });
    }
    @Override
    public void delete(String isbn) {
        bookRepository.findByIsbn(isbn).ifPresent(bookRepository::delete);
    }
}
