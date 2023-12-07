package com.project.challenge.mstransfer.mstransfer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.challenge.mstransfer.mstransfer.DTOs.mock.MockAuthDTO;

@FeignClient(contextId = "ms-external1", name = "ms-external", path = "/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", url = "https://run.mocky.io")
public interface MockClient {

    @GetMapping
    ResponseEntity<MockAuthDTO> getMockAuth();
}
