package com.example.library.controller;

import com.example.library.dto.AuthorDTO;
import com.example.library.exeption.LibraryInternalServerException;
import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/author")
@CrossOrigin
public class AuthorController {

    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() throws LibraryInternalServerException {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok().body(authors);
    }

    @PostMapping
    public ResponseEntity<Author> addNewAuthor(@Valid
                                               @RequestBody
                                                       AuthorDTO authorDTO) throws LibraryInternalServerException {
        Author author = authorService.addNewAuthor(authorDTO);
        return ResponseEntity.created(URI.create("/add-new-author")).body(author);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getOneAuthor(@Valid
                                               @PathVariable int authorId)
            throws LibraryInternalServerException {
        Author author = authorService.getOneAuthor(authorId);
        return ResponseEntity.ok().body(author);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@Valid
                                               @RequestBody AuthorDTO authorDTO,
                                               @PathVariable int authorId)
        throws LibraryInternalServerException {
        Author author = authorService.updateAuthor(authorId, authorDTO);
        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Author> deleteAuthor(@Valid
                                               @PathVariable int authorId) throws LibraryInternalServerException {
        Author author = authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().body(author);
    }
}
