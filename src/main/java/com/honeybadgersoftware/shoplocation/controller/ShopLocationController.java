package com.honeybadgersoftware.shoplocation.controller;

import com.honeybadgersoftware.shoplocation.facade.ShopLocationFacade;
import com.honeybadgersoftware.shoplocation.model.FindShopsRequest;
import com.honeybadgersoftware.shoplocation.model.response.NearbyShopsResponse;
import com.honeybadgersoftware.shoplocation.model.response.ShopIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class ShopLocationController {

    private final ShopLocationFacade shopLocationFacade;

    @PostMapping
    public ResponseEntity<NearbyShopsResponse> findNearbyShopsIds(@RequestBody FindShopsRequest findShopsRequest) {
        return ResponseEntity.ok(shopLocationFacade.getNearbyShopsIds(findShopsRequest));
    }

    @GetMapping
    public ResponseEntity<ShopIdResponse> getShopId(@RequestParam(value = "name") String name){
        return ResponseEntity.ok(shopLocationFacade.getShopId(name));
    }
}
