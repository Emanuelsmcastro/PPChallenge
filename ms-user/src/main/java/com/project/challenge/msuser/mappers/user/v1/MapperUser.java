package com.project.challenge.msuser.mappers.user.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;

import com.project.challenge.msuser.DTOs.user.v1.UserDTO;
import com.project.challenge.msuser.entities.User;
import com.project.challenge.msuser.interfaces.Mapper;

public class MapperUser implements Mapper<UserDTO, User> {
    private static final MapperUser mapper = new MapperUser();

    public MapperUser() {

    }

    public static MapperUser getInstance() {
        return mapper;
    }

    @Override
    public UserDTO toDTO(User entity) {
        if (ObjectUtils.isEmpty(entity))
            return null;
        UserDTO dto = new UserDTO();
        dto.setUuid(entity.getUuid());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setBalance(entity.getBalance());
        dto.setCommonUser(MapperCommonUser.getInstance().toDTO(entity.getCommonUser()));
        dto.setShopKeeper(MapperShopKeeper.getInstance().toDTO(entity.getShopKeeper()));
        return dto;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> entities) {
        if (ObjectUtils.isEmpty(entities))
            return null;
        return entities
                .stream()
                .map((user) -> toDTO(user))
                .collect(Collectors.toList());
    }

}
