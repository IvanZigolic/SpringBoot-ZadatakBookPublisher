package com.example.ZadatakBookPublisher.domain;


import com.example.ZadatakBookPublisher.dto.BookDTO;
import com.example.ZadatakBookPublisher.repository.SpringDataPublisherRepository;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private int pages;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
}
