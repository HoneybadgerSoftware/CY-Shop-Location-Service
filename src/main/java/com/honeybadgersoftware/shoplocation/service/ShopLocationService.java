package com.honeybadgersoftware.shoplocation.service;

import com.honeybadgersoftware.shoplocation.model.response.ShopDto;

import java.util.List;

public interface ShopLocationService {

    List<ShopDto> getShops(List<String> shopNames);

    Long getShopId(String name);
}
