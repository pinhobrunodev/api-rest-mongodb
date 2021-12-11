package com.pinhobrunodev.workshopmongo.services;

import com.pinhobrunodev.workshopmongo.models.dto.PostDTO;
import com.pinhobrunodev.workshopmongo.models.entities.Post;
import com.pinhobrunodev.workshopmongo.repositories.PostRepository;
import com.pinhobrunodev.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    @Transactional(readOnly = true)
    public PostDTO byID(String id){
        return  new PostDTO(getPostById(id));
    }




    // Auxiliary methods

    private Post getPostById(String id){
        Optional<Post> result = repository.findById(id);
        return  result.orElseThrow(()-> new ResourceNotFoundException("Id not found : "+id));
    }



}
