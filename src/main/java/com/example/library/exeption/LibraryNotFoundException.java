package com.example.library.exeption;

public class LibraryNotFoundException extends Exception {


    private static final long serialVersionUID = 5814513696612808322L;

    public LibraryNotFoundException(String message) {
        super(message);
    }
}
