package com.project.challenge.mstransfer.mstransfer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.ShopKeeperDTO;

@FeignClient(contextId = "ms-user-client2", name = "ms-user", path = "ppchallenge/v1/shopkeepers")
public interface ShopKeeperClient {

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<ShopKeeperDTO> findByUuid(@PathVariable(value = "uuid") String uuid);
}