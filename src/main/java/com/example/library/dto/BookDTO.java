package com.example.library.dto;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private String name;
    private Double price;
    private Integer authorId;
    private Integer publisherId;
}
