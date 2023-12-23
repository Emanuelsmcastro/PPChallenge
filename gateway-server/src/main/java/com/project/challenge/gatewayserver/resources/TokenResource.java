package com.project.challenge.gatewayserver.resources;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ppchallenge/v1/token")
public class TokenResource {

	@GetMapping
	public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt) {
		return Collections.singletonMap("principal", jwt);
	}
}
