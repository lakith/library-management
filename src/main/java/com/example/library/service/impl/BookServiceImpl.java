package com.example.library.service.impl;

import com.example.library.dto.BookDTO;
import com.example.library.exeption.LibraryInternalServerException;
import com.example.library.exeption.LibraryNotFoundException;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Publisher;
import com.example.library.repository.BookRepository;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           PublisherService publisherService,
                           AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Override
    public Book addNewBook(BookDTO bookDTO) throws LibraryInternalServerException {
        try{
            Author author = authorService
                    .getOneAuthor(bookDTO.getAuthorId());
            Publisher publisher = publisherService
                    .getOnePublisher(bookDTO.getPublisherId());

            Book book = Book.builder()
                    .name(bookDTO.getName())
                    .price(bookDTO.getPrice())
                    .author(author)
                    .publisher(publisher)
                    .build();
            book = bookRepository.save(book);
            return book;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Book getOneBook(Integer bookId) throws LibraryInternalServerException {
        try{
            Optional<Book> bookOptional = bookRepository.findById(bookId);
            if(bookOptional.isEmpty()) {
                throw new LibraryNotFoundException("Book Not Found");
            }
            return bookOptional.get();
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks() throws LibraryInternalServerException {
       try{
           List<Book> books = bookRepository.findAll();
           if(books.isEmpty()) {
               throw new LibraryNotFoundException("No Books Found");
           }
           return books;
       } catch (Exception e) {
           throw new LibraryInternalServerException(e.getMessage());
       }
    }

    @Override
    public Book updateBook(Integer bookId, BookDTO bookDTO) throws LibraryInternalServerException {
        try{
            Author author = authorService
                    .getOneAuthor(bookDTO.getAuthorId());
            Publisher publisher = publisherService
                    .getOnePublisher(bookDTO.getPublisherId());

            Optional<Book> bookOptional = bookRepository
                    .findById(bookId);
            if(bookOptional.isEmpty()) {
                throw new LibraryNotFoundException("Book Not Found");
            }
            Book book = Book.builder()
                    .name(bookDTO.getName())
                    .price(bookDTO.getPrice())
                    .publisher(publisher)
                    .author(author)
                    .build();
            book = bookRepository.save(book);
            return book;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Book deleteBook(Integer bookId) throws LibraryInternalServerException {
        try{
            Optional<Book> bookOptional = bookRepository
                    .findById(bookId);
            if(bookOptional.isEmpty()) {
                throw new LibraryNotFoundException("Book Not Found");
            }
            bookRepository.deleteById(bookId);
            return bookOptional.get();
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }
}
