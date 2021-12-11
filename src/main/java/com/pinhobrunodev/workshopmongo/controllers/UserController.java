package com.pinhobrunodev.workshopmongo.controllers;

import com.pinhobrunodev.workshopmongo.models.dto.UserDTO;
import com.pinhobrunodev.workshopmongo.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return  ResponseEntity.ok().body(service.findAll());
    }
}
