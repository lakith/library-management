package com.example.library.controller;

import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    BookService bookService;

    @Autowired
    public BookController (BookService bookService) {
        this.bookService = bookService;
    }
}
