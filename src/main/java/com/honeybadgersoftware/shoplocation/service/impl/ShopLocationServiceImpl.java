package com.honeybadgersoftware.shoplocation.service.impl;

import com.honeybadgersoftware.shoplocation.model.entity.ShopEntity;
import com.honeybadgersoftware.shoplocation.model.response.ShopDto;
import com.honeybadgersoftware.shoplocation.repository.ShopLocationRepository;
import com.honeybadgersoftware.shoplocation.service.ShopLocationService;
import com.honeybadgersoftware.shoplocation.utils.mapper.ShopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopLocationServiceImpl implements ShopLocationService {

    private final ShopLocationRepository shopLocationRepository;
    private final ShopMapper shopMapper;

    @Override
    public List<ShopDto> getShops(List<String> shopNames) {
        return filterShopEntities(shopLocationRepository.findAll(), normalizeShopNames(shopNames));
    }

    private List<ShopDto> filterShopEntities(List<ShopEntity> entities, List<String> shopNames) {
        return entities.stream()
                .filter(entity -> isNameContainedInShopNames(entity.getShopName(), shopNames))
                .map(shopMapper::toDto)
                .toList();
    }

    private List<String> normalizeShopNames(List<String> shopNames) {
        return shopNames.stream()
                .map(String::toLowerCase)
                .toList();
    }

    private boolean isNameContainedInShopNames(String name, List<String> shopNames) {
        return shopNames.stream()
                .anyMatch(shopName -> shopName.contains(name.toLowerCase()));
    }

}
