package com.honeybadgersoftware.shoplocation.facade.utils;

import com.honeybadgersoftware.shoplocation.client.maps.api.AzureMapsApi;
import com.honeybadgersoftware.shoplocation.client.maps.model.AzureShopsLocationResponse;
import com.honeybadgersoftware.shoplocation.model.FindShopsRequest;
import com.honeybadgersoftware.shoplocation.model.response.NearbyShopsIdsResponse;
import com.honeybadgersoftware.shoplocation.service.ShopLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShopLocationFacade {

    private final ShopLocationService shopLocationService;
    private final AzureMapsApi azureMapsApi;

    public NearbyShopsIdsResponse getNearbyShopsIds(FindShopsRequest findShopsRequest){

        AzureShopsLocationResponse azureShopsLocationResponse =
                azureMapsApi.searchPoiCategory(
                        findShopsRequest.getLatitude(),
                        findShopsRequest.getLongitude(),
                        findShopsRequest.getRadius());



        return new NearbyShopsIdsResponse(shopLocationService.getShops(List.of(")")));
    }

}
