package com.juli0mendes.pocspringnative.controller.dto;

import java.io.Serializable;
import java.util.UUID;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2523889511081897391L;

    private UUID id;

    private String name;

    public UserDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
