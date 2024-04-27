package com.honeybadgersoftware.shoplocation.utils;

import java.util.List;

public interface OneToOneFactory <T, R >{

    R map (T t);

    default List<R> map(List<T> t){
        return t.stream().map(this::map).toList();
    }
}
