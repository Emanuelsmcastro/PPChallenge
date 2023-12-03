package com.project.challenge.msuser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.challenge.msuser.entities.CommonUser;

public interface CommonUserRepository extends JpaRepository<Long, CommonUser> {

    Optional<CommonUser> findByUuid(String uuid);

}
