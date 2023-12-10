package com.project.challenge.mstransfer.mstransfer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.challenge.mstransfer.mstransfer.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

    Optional<Transfer> findByUuid(String uuid);
}
