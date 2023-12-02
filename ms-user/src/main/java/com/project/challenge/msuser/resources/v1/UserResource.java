package com.project.challenge.msuser.resources.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.msuser.DTOs.user.v1.UserDTO;
import com.project.challenge.msuser.services.v1.UserService;

@RestController
@RequestMapping(value = "/ppchallenge/v1/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/search/{uuid}")
    public ResponseEntity<UserDTO> getUserByUuid(@PathVariable(name = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.getUserByUuid(uuid));
    }

}
