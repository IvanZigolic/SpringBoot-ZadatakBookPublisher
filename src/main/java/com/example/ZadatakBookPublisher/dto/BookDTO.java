package com.example.ZadatakBookPublisher.dto;

import com.example.ZadatakBookPublisher.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookDTO {
    private String title;
    private String isbn;
    private int pages;
    private BigDecimal price;
    private String publisher;

    public BookDTO(Book book){
        this.title = book.getTitle();
        this.isbn = book.getIsbn();
        this.pages = book.getPages();
        this.price = book.getPrice();
        this.publisher = book.getPublisher().getName();
    }

}
