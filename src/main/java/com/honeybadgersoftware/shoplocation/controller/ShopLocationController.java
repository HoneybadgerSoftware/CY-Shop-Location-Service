package com.honeybadgersoftware.shoplocation.controller;

import com.honeybadgersoftware.shoplocation.model.FindShopsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class ShopLocationController {

    @PostMapping
    public ResponseEntity<Void> findNearbyShops(FindShopsRequest findShopsRequest) {
        return null;
    }
}
