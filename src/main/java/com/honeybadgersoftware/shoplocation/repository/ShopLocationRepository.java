package com.honeybadgersoftware.shoplocation.repository;

import com.honeybadgersoftware.shoplocation.model.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopLocationRepository extends JpaRepository<ShopEntity, Long> {
}
