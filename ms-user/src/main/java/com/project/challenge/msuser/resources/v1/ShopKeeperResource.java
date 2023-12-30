package com.project.challenge.msuser.resources.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.challenge.msuser.DTOs.user.v1.ShopKeeperDTO;
import com.project.challenge.msuser.infra.exceptions.DTOs.BasicResponseExceptionDTO;
import com.project.challenge.msuser.services.v1.ShopKeeperService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Shopkeeper Resource V1", description = "These endpoints are responsible for handling all available functionalities related to the Shopkeeper.")
@RequestMapping(value = "/ppchallenge/v1/shopkeepers")
public class ShopKeeperResource {

    @Autowired
    private ShopKeeperService service;

    @GetMapping(value = "/{uuid}")
    @CrossOrigin(origins = {"http://localhost:8765"})
    @Operation(summary = "Find Shopkeeper.", description = "Find Shopkeeper by uuid.", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ShopKeeperDTO.class)) }),
			@ApiResponse(description = "Not found", responseCode = "404", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = BasicResponseExceptionDTO.class)) }) })
    public ResponseEntity<ShopKeeperDTO> findByUuid(@PathVariable(value = "uuid") String uuid) {
        return ResponseEntity.ok().body(service.findByUuid(uuid));
    }
}
