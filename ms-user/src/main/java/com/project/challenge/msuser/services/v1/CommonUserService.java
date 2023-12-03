package com.project.challenge.msuser.services.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.challenge.msuser.DTOs.user.v1.CommonUserDTO;
import com.project.challenge.msuser.entities.CommonUser;
import com.project.challenge.msuser.infra.exceptions.CommonUserNotFound;
import com.project.challenge.msuser.mappers.user.v1.MapperCommonUser;
import com.project.challenge.msuser.repositories.CommonUserRepository;

@Service
public class CommonUserService {

    @Autowired
    private CommonUserRepository rep;

    public CommonUserDTO findByUuid(String uuid) {
        return MapperCommonUser
                .getInstance()
                .toDTO(getEntityByUuid(uuid));
    }

    private CommonUser getEntityByUuid(String uuid) {
        return rep.findByUuid(uuid)
                .orElseThrow(
                        () -> (new CommonUserNotFound(
                                String.format("User (%s) not found.", uuid))));
    }

}
