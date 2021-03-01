package com.example.library.exeption;

public class LibraryInternalServerException extends Exception {

    private static final long serialVersionUID = -4141411450779880392L;

    public LibraryInternalServerException(String message) {
        super(message);
    }
}
