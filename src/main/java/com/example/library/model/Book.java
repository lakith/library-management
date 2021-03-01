package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("bookId")
    private Integer bookId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double price;

    @ManyToOne
    @JsonProperty("author")
    private Author author;

    @ManyToOne
    @JsonProperty("publisher")
    private Publisher publisher;

    public Book(Integer bookId,
                String name,
                Double price) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
    }
}
