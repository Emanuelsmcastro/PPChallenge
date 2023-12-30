package com.project.challenge.mstransfer.mstransfer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserBalanceDTO;
import com.project.challenge.mstransfer.mstransfer.DTOs.user.v1.UserDTO;

@FeignClient(contextId = "ms-user-client3", name = "ms-user", path = "ppchallenge/v1/users")
public interface UserClient {

	@GetMapping(value = "/search/common-user/{uuid}")
	public ResponseEntity<UserDTO> getUserByCommonUserUuid(@PathVariable String uuid);

	@GetMapping(value = "/search/shopkeeper/{uuid}")
	public ResponseEntity<UserDTO> getUserByShopKeeperUuid(@PathVariable String uuid);

	@GetMapping(value = "/search/all/{uuid}")
	public ResponseEntity<UserDTO> getUserByShopKeeperOrCommonUserUuid(@PathVariable String uuid);

	@PostMapping(value = "/balances")
	public ResponseEntity<UserDTO> updateBalance(@RequestBody UserBalanceDTO userBalance);
}