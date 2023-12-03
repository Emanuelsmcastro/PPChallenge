package com.project.challenge.msuser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.challenge.msuser.entities.ShopKeeper;

public interface ShopKeeperRespository extends JpaRepository<Long, ShopKeeper> {

    Optional<ShopKeeper> findByUuid(String uuid);
}
