package com.project.challenge.msuser.services.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.challenge.msuser.DTOs.user.v1.ShopKeeperDTO;
import com.project.challenge.msuser.entities.ShopKeeper;
import com.project.challenge.msuser.infra.exceptions.CommonUserNotFound;
import com.project.challenge.msuser.mappers.user.v1.MapperShopKeeper;
import com.project.challenge.msuser.repositories.ShopKeeperRepository;

@Service
public class ShopKeeperService {

    @Autowired
    private ShopKeeperRepository rep;

    public ShopKeeperDTO findByUuid(String uuid) {
        return MapperShopKeeper
                .getInstance()
                .toDTO(getEntityByUuid(uuid));
    }

    private ShopKeeper getEntityByUuid(String uuid) {
        return rep.findByUuid(uuid)
                .orElseThrow(
                        () -> (new CommonUserNotFound(
                                String.format("User (%s) not found.", uuid))));
    }

}
