package com.pinhobrunodev.workshopmongo.services;

import com.pinhobrunodev.workshopmongo.models.dto.UserDTO;
import com.pinhobrunodev.workshopmongo.models.entities.User;
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


    @Transactional
    public UserDTO insert(UserDTO dto){
        User user =  new User();
        return new UserDTO(repository.save(copyDtoToEntity(user,dto)));
    }





    @Transactional(readOnly = true)
    public UserDTO findById(String id){
        return repository.findById(id).map(UserDTO::new).orElseThrow(()-> new IllegalArgumentException("deu ruim no findbyid"));
    }


    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }


    // Auxiliary methods

    private User copyDtoToEntity(User user,UserDTO dto){
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

}
