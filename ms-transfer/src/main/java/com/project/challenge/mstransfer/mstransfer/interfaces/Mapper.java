package com.project.challenge.mstransfer.mstransfer.interfaces;

import java.util.List;

public interface Mapper<T, B> {

    T convert(B entity);

    List<T> convertList(List<B> entities);
}
