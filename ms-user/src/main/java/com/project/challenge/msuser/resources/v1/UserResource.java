package com.project.challenge.msuser.resources.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.msuser.DTOs.user.v1.UserBalanceDTO;
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

    @GetMapping(value = "/search/common-user/{uuid}")
    public ResponseEntity<UserDTO> getUserByCommonUserUuid(@PathVariable(name = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.getUserByCommonUserUuid(uuid));
    }

    @GetMapping(value = "/search/shopkeeper/{uuid}")
    public ResponseEntity<UserDTO> getUserByShopKeeperUuid(@PathVariable(name = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.getUserByShopKeeperUuid(uuid));
    }

    @PostMapping(value = "/balances")
    public ResponseEntity<UserDTO> updateBalance(@RequestBody UserBalanceDTO userBalance) {
        return ResponseEntity.ok().body(service.saveBalanceToUser(userBalance));
    }

}
