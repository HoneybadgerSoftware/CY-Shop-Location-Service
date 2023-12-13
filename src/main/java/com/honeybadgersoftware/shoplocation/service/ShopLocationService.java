package com.honeybadgersoftware.shoplocation.service;

import com.honeybadgersoftware.shoplocation.model.ShopNamesEnum;

import java.util.List;

public interface ShopLocationService {

    List<Long> getShops(List<String> shopNames);
}
