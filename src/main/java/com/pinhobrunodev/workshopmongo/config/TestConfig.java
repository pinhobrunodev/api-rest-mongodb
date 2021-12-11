package com.pinhobrunodev.workshopmongo.config;

import com.pinhobrunodev.workshopmongo.models.entities.User;
import com.pinhobrunodev.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig{

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        userRepository.deleteAll();
        User maria = new User(null,"Maria Brown","maria@gmail.com");
        User alex = new User(null,"Alex Green","alex@gmail.com");
        User bob = new User(null,"Bob Gray","bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob));
    }

}
