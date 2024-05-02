package com.honeybadgersoftware.shoplocation.utils.mapper;

import com.honeybadgersoftware.shoplocation.model.entity.ShopEntity;
import com.honeybadgersoftware.shoplocation.model.response.ShopDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    ShopDto toDto(ShopEntity shop);

    ShopEntity toEntity(ShopDto shop);
}
