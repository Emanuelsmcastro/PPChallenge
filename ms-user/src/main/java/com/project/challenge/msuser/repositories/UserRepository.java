package com.project.challenge.msuser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.challenge.msuser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUuid(String uuid);
}
