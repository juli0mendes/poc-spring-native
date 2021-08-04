package com.juli0mendes.pocspringnative.controller;

import com.juli0mendes.pocspringnative.controller.dto.UserDTO;
import com.juli0mendes.pocspringnative.core.UserCore;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Random;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("poc-spring-native/v1/users")
public class UserController {

    private final UserCore userCore;

    public UserController(final UserCore userCore) {
        this.userCore = userCore;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getById(@Validated @RequestBody UserDTO userDTO) {
        UserDTO userDTOCreated = this.userCore.create(userDTO);
        return ResponseEntity.created(this.getLocation(userDTOCreated.getId().toString())).build();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getById(@PathVariable("id") String id) {
        UserDTO userDTO = this.userCore.getById(UUID.fromString(id));
        return ResponseEntity.ok(userDTO);
    }

    private URI getLocation(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
