package com.project.challenge.msuser.services.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.challenge.msuser.DTOs.user.v1.UserDTO;
import com.project.challenge.msuser.entities.User;
import com.project.challenge.msuser.infra.exceptions.UserNotFound;
import com.project.challenge.msuser.mappers.user.v1.MapperUser;
import com.project.challenge.msuser.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserDTO getUserByUuid(String uuid) {
        return MapperUser
                .getInstance()
                .toDTO(findUserByUuid(uuid));
    }

    private User findUserByUuid(String uuid) {
        return repo.findByUuid(uuid)
                .orElseThrow(() -> new UserNotFound(String.format("User with UUID (%s) not found.", uuid)));
    }

}
