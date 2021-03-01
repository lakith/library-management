package com.example.library.service;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.BookDTO;
import com.example.library.exeption.LibraryInternalServerException;
import com.example.library.model.Author;
import com.example.library.model.Book;

import java.util.List;

public interface AuthorService {


    Author addNewAuthor(AuthorDTO authorDTO) throws LibraryInternalServerException;

    Author getOneAuthor(Integer authorId) throws LibraryInternalServerException;

    List<Author> getAllAuthors() throws LibraryInternalServerException;

    Author updateAuthor(Integer authorId, AuthorDTO authorDTO) throws LibraryInternalServerException;

    Author deleteAuthor(Integer authorId) throws LibraryInternalServerException;

}
