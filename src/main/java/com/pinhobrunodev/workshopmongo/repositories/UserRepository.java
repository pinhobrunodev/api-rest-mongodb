package com.pinhobrunodev.workshopmongo.repositories;

import com.pinhobrunodev.workshopmongo.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {
}
