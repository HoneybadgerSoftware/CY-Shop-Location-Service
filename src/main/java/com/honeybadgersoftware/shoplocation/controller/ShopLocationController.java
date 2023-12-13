package com.honeybadgersoftware.shoplocation.controller;

import com.honeybadgersoftware.shoplocation.facade.ShopLocationFacade;
import com.honeybadgersoftware.shoplocation.model.FindShopsRequest;
import com.honeybadgersoftware.shoplocation.model.response.NearbyShopsIdsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class ShopLocationController {

    private final ShopLocationFacade shopLocationFacade;

    @PostMapping
    public ResponseEntity<NearbyShopsIdsResponse> findNearbyShopsIds(FindShopsRequest findShopsRequest) {
        return ResponseEntity.ok(shopLocationFacade.getNearbyShopsIds(findShopsRequest));
    }
}
