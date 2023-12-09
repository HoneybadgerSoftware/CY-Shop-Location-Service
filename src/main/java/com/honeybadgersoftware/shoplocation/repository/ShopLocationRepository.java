package com.honeybadgersoftware.shoplocation.repository;

import com.honeybadgersoftware.shoplocation.model.entity.ShopLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopLocationRepository extends JpaRepository<ShopLocationEntity, Long> {
}
