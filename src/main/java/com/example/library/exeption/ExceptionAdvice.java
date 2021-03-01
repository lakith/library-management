package com.example.library.exeption;

import com.example.library.model.LibraryError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LibraryInternalServerException.class)
    public ResponseEntity<LibraryError> mapLibraryInternalServerErrorException(
            LibraryInternalServerException ex,
            WebRequest request
    ) {
        LibraryError libraryError = LibraryError.builder()
                .errorCode(LibraryError.generateUUID())
                .responceCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(libraryError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public LibraryError mapLibraryNotFoundException(
            LibraryNotFoundException ex
    ) {
        LibraryError libraryError = LibraryError.builder()
                .errorCode(LibraryError.generateUUID())
                .responceCode(HttpStatus.BAD_REQUEST.value())
                .errorMessage(ex.getMessage())
                .build();
        return libraryError;
    }

    @ExceptionHandler(Exception.class)
    public Exception mapAllException(
            Exception ex
    ) {
        return ex;
    }
}
