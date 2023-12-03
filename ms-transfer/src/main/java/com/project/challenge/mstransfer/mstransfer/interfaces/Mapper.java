package com.project.challenge.mstransfer.mstransfer.interfaces;

import java.util.List;

public interface Mapper<T, B> {

    T toDTO(B entity);

    List<T> toDTOList(List<B> entities);
}
