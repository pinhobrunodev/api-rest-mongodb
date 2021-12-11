package com.pinhobrunodev.workshopmongo.models.dto;

import com.pinhobrunodev.workshopmongo.models.entities.User;

public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}