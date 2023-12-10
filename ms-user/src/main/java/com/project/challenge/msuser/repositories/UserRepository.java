package com.project.challenge.msuser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.challenge.msuser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUuid(String uuid);

    @Query(value = "SELECT u FROM User u WHERE u.commonUser.uuid = :uuid")
    Optional<User> findByCommonUserUuid(@Param("uuid") String uuid);

    @Query(value = "SELECT u FROM User u WHERE u.shopKeeper.uuid = :uuid")
    Optional<User> findByShopKeeperUuid(@Param("uuid") String uuid);

    @Query("SELECT u FROM User u LEFT JOIN u.commonUser c LEFT JOIN u.shopKeeper s WHERE c.uuid = :uuid OR s.uuid = :uuid")
    Optional<User> findByShopKeeperOrCommonUserUuid(@Param("uuid") String uuid);

    @Modifying
    @Query("UPDATE User u SET u.balance = :value WHERE u.uuid = :uuid")
    void updateUserBalance(@Param("uuid") String uuid, @Param("value") Double value);
}
