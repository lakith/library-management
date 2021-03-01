package com.example.library.service;

import com.example.library.dto.BookDTO;
import com.example.library.dto.PublisherDTO;
import com.example.library.exeption.LibraryInternalServerException;
import com.example.library.model.Book;
import com.example.library.model.Publisher;

import java.util.List;

public interface BookService {

    Book addNewBook(BookDTO bookDTO) throws LibraryInternalServerException;

    Book getOneBook(Integer bookId) throws LibraryInternalServerException;

    List<Book> getAllBooks() throws LibraryInternalServerException;

    Book updateBook(Integer bookId, BookDTO bookDTO) throws LibraryInternalServerException;

    Book deleteBook(Integer bookId) throws LibraryInternalServerException;
}
