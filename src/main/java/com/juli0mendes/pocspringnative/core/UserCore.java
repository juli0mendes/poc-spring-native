package com.juli0mendes.pocspringnative.core;

import com.juli0mendes.pocspringnative.controller.dto.UserDTO;
import com.juli0mendes.pocspringnative.domain.User;
import com.juli0mendes.pocspringnative.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserCore {

    private final UserRepository userRepository;

    public UserCore(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(UserDTO userDTO) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(userDTO.getName());

        User userCreated = this.userRepository.save(user);

        return new UserDTO(userCreated.getId(), userCreated.getName());
    }

    public UserDTO getById(UUID id) {
        User user = this.userRepository.findById(id).get();
        return new UserDTO(user.getId(), user.getName());
    }
}
