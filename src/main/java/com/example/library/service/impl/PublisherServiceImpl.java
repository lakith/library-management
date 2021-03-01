package com.example.library.service.impl;

import com.example.library.dto.PublisherDTO;
import com.example.library.exeption.LibraryInternalServerException;
import com.example.library.exeption.LibraryNotFoundException;
import com.example.library.model.Publisher;
import com.example.library.repository.PublisherRepository;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl (PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher addNewPublisher(PublisherDTO publisherDTO) throws LibraryInternalServerException {
        try{
            Publisher publisher = Publisher.builder()
                    .name(publisherDTO.getName())
                    .address(publisherDTO.getAddress())
                    .build();
            publisher = publisherRepository.save(publisher);
            return publisher;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Publisher getOnePublisher(Integer publisherId) throws LibraryInternalServerException {
        try{
            Optional<Publisher> publisher = publisherRepository
                    .findById(publisherId);
            if(publisher.isEmpty()) {
                throw new LibraryNotFoundException("Publisher Not Found");
            }
            return publisher.get();
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public List<Publisher> getAllPublishers() throws LibraryInternalServerException {
        try{
            List<Publisher> publishers = publisherRepository.findAll();
            if(publishers.isEmpty()) {
                throw new LibraryNotFoundException("Publishers Not Found");
            }
            return publishers;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Publisher updatePublisher(Integer publisherId, PublisherDTO publisherDTO) throws LibraryInternalServerException {
        try{
            Optional<Publisher> optionalPublisher = publisherRepository
                    .findById(publisherId);
            if(optionalPublisher.isEmpty()) {
                throw new LibraryNotFoundException("Publisher Not Found");
            }
            Publisher publisher = optionalPublisher.get();
            publisher.setName(publisherDTO.getName());
            publisher.setName(publisherDTO.getAddress());
            publisher = publisherRepository.save(publisher);
            return publisher;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }

    @Override
    public Publisher deletePublisher(Integer publisherId) throws LibraryInternalServerException {
        try{
            Optional<Publisher> optionalPublisher = publisherRepository
                    .findById(publisherId);
            if(optionalPublisher.isEmpty()) {
                throw new LibraryNotFoundException("Publisher Not Found");
            }
            Publisher publisher = optionalPublisher.get();
            publisherRepository.deleteById(publisher.getPublisherId());
            return publisher;
        } catch (Exception e) {
            throw new LibraryInternalServerException(e.getMessage());
        }
    }
}
