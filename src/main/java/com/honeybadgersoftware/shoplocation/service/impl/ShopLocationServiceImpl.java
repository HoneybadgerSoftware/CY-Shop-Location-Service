package com.honeybadgersoftware.shoplocation.service.impl;

import com.honeybadgersoftware.shoplocation.repository.ShopLocationRepository;
import com.honeybadgersoftware.shoplocation.service.ShopLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopLocationServiceImpl implements ShopLocationService {

    private final ShopLocationRepository shopLocationRepository;

    @Override
    public List<Long> getShops(List<String> shopNames) {
        return null;
    }
}
