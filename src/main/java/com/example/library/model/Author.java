package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("authorId")
    private Integer authorId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;

    public Author(Integer authorId,
                     String name,
                     String address) {
        this.authorId = authorId;
        this.name = name;
        this.address = address;
    }
}
