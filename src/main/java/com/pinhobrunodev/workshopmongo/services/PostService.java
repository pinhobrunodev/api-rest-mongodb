package com.pinhobrunodev.workshopmongo.services;

import com.pinhobrunodev.workshopmongo.models.dto.PostDTO;
import com.pinhobrunodev.workshopmongo.models.entities.Post;
import com.pinhobrunodev.workshopmongo.repositories.PostRepository;
import com.pinhobrunodev.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    @Transactional(readOnly = true)
    public PostDTO byID(String id) {
        return new PostDTO(getPostById(id));
    }


    @Transactional(readOnly = true)
    public List<PostDTO> byTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title).stream().map(PostDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostDTO> fullSearch(String text, String start, String end) {
        Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
        Instant endMoment = convertMoment(end, Instant.now());
        List<Post> list = repository.fullSearch(text, startMoment, endMoment);
        return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
    }



    // Auxiliary methods

    private Post getPostById(String id) {
        Optional<Post> result = repository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id not found : " + id));
    }

    private Instant convertMoment(String orignalText, Instant alternative) {
        try {
            return Instant.parse(orignalText);
        }
        catch (DateTimeParseException e) {
            return alternative;
        }
    }

}
