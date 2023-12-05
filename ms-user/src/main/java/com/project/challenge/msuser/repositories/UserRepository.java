package com.project.challenge.msuser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.challenge.msuser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUuid(String uuid);

    @Query(value = "SELECT u FROM User u WHERE u.commonUser.uuid = :uuid")
    Optional<User> findByCommonUserUuid(@Param("uuid") String uuid);

    @Query(value = "SELECT u FROM User u WHERE u.shopKeeper.uuid = :uuid")
    Optional<User> findByShopKeeperUuid(@Param("uuid") String uuid);
}
