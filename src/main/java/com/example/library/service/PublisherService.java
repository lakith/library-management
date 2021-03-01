package com.example.library.service;

import com.example.library.dto.PublisherDTO;
import com.example.library.exeption.LibraryInternalServerException;
import com.example.library.exeption.LibraryNotFoundException;
import com.example.library.model.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher addNewPublisher(PublisherDTO publisherDTO) throws LibraryInternalServerException;

    Publisher getOnePublisher(Integer publisherId) throws LibraryInternalServerException;

    List<Publisher> getAllPublishers() throws LibraryInternalServerException;

    Publisher updatePublisher(Integer publisherId, PublisherDTO publisherDTO) throws LibraryInternalServerException;

    Publisher deletePublisher(Integer publisherId) throws LibraryNotFoundException, LibraryInternalServerException;
}
