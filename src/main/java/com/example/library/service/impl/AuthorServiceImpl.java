package com.example.library.service.impl;

import com.example.library.dto.AuthorDTO;
import com.example.library.exeption.LibraryInternalServerException;
import com.example.library.exeption.LibraryNotFoundException;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addNewAuthor(AuthorDTO authorDTO) throws LibraryInternalServerException {
        try{
            Author author = Author.builder()
                    .name(authorDTO.getName())
                    .address(authorDTO.getAddress())
                    .build();
            author = authorRepository.save(author);
            return author;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Author getOneAuthor(Integer authorId) throws LibraryInternalServerException {
        try{
            Optional<Author> author = authorRepository
                    .findById(authorId);
            if(author.isEmpty()) {
                throw new LibraryNotFoundException("Author Not Found");
            }
            return author.get();
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public List<Author> getAllAuthors() throws LibraryInternalServerException {
        try{
            List<Author> authors = authorRepository.findAll();
            if(authors.isEmpty()) {
                throw new LibraryNotFoundException("Authors Not Found");
            }
            return authors;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Author updateAuthor(Integer authorId, AuthorDTO authorDTO) throws LibraryInternalServerException {
        try{
            Optional<Author> optionalAuthor = authorRepository
                    .findById(authorId);
            if(optionalAuthor.isEmpty()) {
                throw new LibraryNotFoundException("Author Not Found");
            }
            Author author = optionalAuthor.get();
            author.setName(authorDTO.getName());
            author.setAddress(authorDTO.getAddress());
            author = authorRepository.save(author);
            return author;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Author deleteAuthor(Integer authorId) throws LibraryInternalServerException {
        try{
            Optional<Author> optionalPublisher = authorRepository
                    .findById(authorId);
            if(optionalPublisher.isEmpty()) {
                throw new LibraryNotFoundException("Author Not Found");
            }
            Author author = optionalPublisher.get();
            authorRepository.deleteById(author.getAuthorId());
            return author;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }
}
