package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("publisherId")
    private Integer publisherId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Book> books;

    public Publisher(Integer publisherId,
                     String name,
                     String address) {
        this.publisherId = publisherId;
        this.name = name;
        this.address = address;
    }
}
