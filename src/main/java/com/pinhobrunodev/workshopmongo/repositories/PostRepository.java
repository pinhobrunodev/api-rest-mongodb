package com.pinhobrunodev.workshopmongo.repositories;

import com.pinhobrunodev.workshopmongo.models.entities.Post;
import com.pinhobrunodev.workshopmongo.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PostRepository extends MongoRepository<Post,String> {

    List<Post> findByTitle(String title);
}
