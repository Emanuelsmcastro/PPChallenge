package com.project.challenge.msuser.resources.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.msuser.DTOs.user.v1.CommonUserDTO;
import com.project.challenge.msuser.services.v1.CommonUserService;

@RestController
@RequestMapping(value = "/ppchallenge/v1/common-users")
public class CommonUserResource {

    @Autowired
    private CommonUserService service;

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<CommonUserDTO> findByUuid(@PathVariable(name = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.findByUuid(uuid));
    }
}
