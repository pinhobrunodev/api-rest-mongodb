package com.pinhobrunodev.workshopmongo.controllers;

import com.pinhobrunodev.workshopmongo.models.dto.PostDTO;
import com.pinhobrunodev.workshopmongo.models.dto.UserDTO;
import com.pinhobrunodev.workshopmongo.models.entities.User;
import com.pinhobrunodev.workshopmongo.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id,@RequestBody UserDTO dto){
        return ResponseEntity.ok().body(service.update(id,dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return  ResponseEntity.ok().body(service.findAll());
    }


    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<PostDTO>> getUserPosts(@PathVariable String id){
        return  ResponseEntity.ok().body(service.getUserPost(id));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        return  ResponseEntity.ok().body(service.findById(id));
    }
}
