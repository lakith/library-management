package com.example.library.dto;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    private String name;
    private String address;
}
