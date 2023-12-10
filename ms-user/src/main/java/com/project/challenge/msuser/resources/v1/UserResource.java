package com.project.challenge.msuser.resources.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.msuser.DTOs.user.v1.UserBalanceDTO;
import com.project.challenge.msuser.DTOs.user.v1.UserDTO;
import com.project.challenge.msuser.infra.exceptions.DTOs.BasicResponseExceptionDTO;
import com.project.challenge.msuser.services.v1.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "User Resource V1", description = "These endpoints are responsible for handling all available functionalities related to the user.")
@RequestMapping(value = "/ppchallenge/v1/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    @Operation(summary = "Find all users.", description = "Returns all users with paging system.", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
            })
    })
    public ResponseEntity<PagedModel<EntityModel<UserDTO>>> findAllUsers(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(service.findAllUsers(pageable));
    }

    @GetMapping(value = "/search/{uuid}")
    @Operation(summary = "Find user.", description = "Find user by uuid.", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(description = "Not found", responseCode = "404", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = BasicResponseExceptionDTO.class))
            })
    })
    public ResponseEntity<UserDTO> getUserByUuid(@PathVariable(value = "uuid") String uuid) {
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

    @GetMapping(value = "/search/all/{uuid}")
    public ResponseEntity<UserDTO> getUserByShopKeeperOrCommonUserUuid(@PathVariable(name = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.getUserByShopKeeperOrCommonUserUuid(uuid));
    }

    @PostMapping(value = "/balances")
    public ResponseEntity<UserDTO> updateBalance(@RequestBody UserBalanceDTO userBalance) {
        return ResponseEntity.ok().body(service.saveBalanceToUser(userBalance));
    }

}
