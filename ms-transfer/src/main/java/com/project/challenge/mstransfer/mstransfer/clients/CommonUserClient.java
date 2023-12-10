package com.project.challenge.mstransfer.mstransfer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.CommonUserDTO;

@Component
@FeignClient(contextId = "ms-user-client1", name = "ms-user", path = "ppchallenge/v1/common-users")
public interface CommonUserClient {

    @GetMapping(value = "/{uuid}")
    ResponseEntity<CommonUserDTO> findByUuid(@PathVariable(value = "uuid") String uuid);
}
