package com.project.challenge.mstransfer.mstransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTransferApplication.class, args);
	}

}
