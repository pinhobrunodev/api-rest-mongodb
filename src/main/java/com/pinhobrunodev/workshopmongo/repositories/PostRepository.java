package com.pinhobrunodev.workshopmongo.repositories;

import com.pinhobrunodev.workshopmongo.models.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface PostRepository extends MongoRepository<Post,String> {


    //Query methods with MongoDB Syntax
    @Query("{<'title'>: { $regex: ?0, $options: '<i>' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String title);
}
