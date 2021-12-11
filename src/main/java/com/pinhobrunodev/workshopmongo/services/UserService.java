package com.pinhobrunodev.workshopmongo.services;

import com.pinhobrunodev.workshopmongo.models.dto.UserDTO;
import com.pinhobrunodev.workshopmongo.models.entities.User;
import com.pinhobrunodev.workshopmongo.repositories.UserRepository;
import com.pinhobrunodev.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;


    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User();
        return new UserDTO(repository.save(copyDtoToEntity(user, dto)));
    }


    @Transactional
    public UserDTO update(String id, UserDTO dto) {
        return new UserDTO(repository.save(updateAux(id,dto)));
    }


    @Transactional(readOnly = true)
    public UserDTO findById(String id) {
        return new UserDTO(getEntityById(id));
    }


    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }


    // Auxiliary methods

    private User copyDtoToEntity(User user, UserDTO dto) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }


    private User getEntityById(String id) {
        Optional<User> result = repository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id not found : " + id));
    }


    private User updateAux(String id, UserDTO dto) {
        User user = getEntityById(id);
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        return user;
    }
}
