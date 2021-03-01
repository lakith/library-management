package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryError {

    private UUID errorCode;
    private int responceCode;
    private String errorMessage;

    public static UUID generateUUID () {
        return UUID.randomUUID();
    }
}
