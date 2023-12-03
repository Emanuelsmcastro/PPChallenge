package com.project.challenge.msuser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.challenge.msuser.entities.ShopKeeper;

public interface ShopKeeperRepository extends JpaRepository<ShopKeeper, Long> {

    Optional<ShopKeeper> findByUuid(String uuid);
}
