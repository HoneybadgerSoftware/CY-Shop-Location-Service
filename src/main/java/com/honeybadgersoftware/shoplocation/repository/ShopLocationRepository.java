package com.honeybadgersoftware.shoplocation.repository;

import com.honeybadgersoftware.shoplocation.model.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopLocationRepository extends JpaRepository<ShopEntity, Long> {

    @Query("SELECT e.id FROM ShopEntity e WHERE e.shopName = :name")
    Long findIdByShopName(String name);
}
