package com.project.challenge.msuser.mappers.user.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;

import com.project.challenge.msuser.DTOs.user.v1.ShopKeeperDTO;
import com.project.challenge.msuser.entities.ShopKeeper;
import com.project.challenge.msuser.interfaces.Mapper;

public class MapperShopKeeper implements Mapper<ShopKeeperDTO, ShopKeeper> {
    private static final MapperShopKeeper mapper = new MapperShopKeeper();

    public MapperShopKeeper() {

    }

    public static MapperShopKeeper getInstance() {
        return mapper;
    }

    @Override
    public ShopKeeperDTO toDTO(ShopKeeper entity) {
        if (ObjectUtils.isEmpty(entity))
            return null;
        ShopKeeperDTO dto = new ShopKeeperDTO();
        dto.setUuid(entity.getUuid());
        dto.setYearsInTheCompany(entity.getYearsInTheCompany());
        return dto;
    }

    @Override
    public List<ShopKeeperDTO> toDTOList(List<ShopKeeper> entities) {
        return entities
                .stream()
                .map(entity -> (toDTO(entity)))
                .collect(Collectors.toList());
    }

}
