package com.project.challenge.msuser.resources.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.msuser.DTOs.user.v1.ShopKeeperDTO;
import com.project.challenge.msuser.services.v1.ShopKeeperService;

@RestController
@RequestMapping(value = "/ppchallenge/v1/shopkeepers")
public class ShopKeeperResource {

    @Autowired
    private ShopKeeperService service;

    @GetMapping(value = "/{uuid}")
    @CrossOrigin(origins = {"http://localhost:8765"})
    public ResponseEntity<ShopKeeperDTO> findByUuid(@PathVariable(value = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.findByUuid(uuid));
    }
}
