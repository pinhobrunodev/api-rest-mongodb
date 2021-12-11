package com.pinhobrunodev.workshopmongo.services;

import com.pinhobrunodev.workshopmongo.models.dto.UserDTO;
import com.pinhobrunodev.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;






    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

}
