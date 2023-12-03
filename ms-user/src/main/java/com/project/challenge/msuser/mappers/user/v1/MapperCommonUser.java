package com.project.challenge.msuser.mappers.user.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;

import com.project.challenge.msuser.DTOs.user.v1.CommonUserDTO;
import com.project.challenge.msuser.entities.CommonUser;
import com.project.challenge.msuser.interfaces.Mapper;

public class MapperCommonUser implements Mapper<CommonUserDTO, CommonUser> {
    private static final MapperCommonUser mapper = new MapperCommonUser();

    public MapperCommonUser() {

    }

    public static MapperCommonUser getInstance() {
        return mapper;
    }

    @Override
    public CommonUserDTO toDTO(CommonUser entity) {
        if (ObjectUtils.isEmpty(entity))
            return null;
        CommonUserDTO dto = new CommonUserDTO();
        dto.setUuid(entity.getUuid());
        dto.setTransferLimit(entity.getTransferLimit());
        return dto;
    }

    @Override
    public List<CommonUserDTO> toDTOList(List<CommonUser> entities) {
        return entities
                .stream()
                .map(
                        entity -> (toDTO(entity)))
                .collect(Collectors.toList());
    }

}
