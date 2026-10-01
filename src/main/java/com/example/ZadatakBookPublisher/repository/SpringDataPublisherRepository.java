package com.example.ZadatakBookPublisher.repository;

import com.example.ZadatakBookPublisher.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataPublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByName(String name);
}
