package com.honeybadgersoftware.shoplocation.facade;

import com.honeybadgersoftware.shoplocation.client.maps.api.AzureMapsApi;
import com.honeybadgersoftware.shoplocation.client.maps.model.AzureShopsLocationResponse;
import com.honeybadgersoftware.shoplocation.client.maps.model.Result;
import com.honeybadgersoftware.shoplocation.factory.AzureResultToNamesStringsFactory;
import com.honeybadgersoftware.shoplocation.model.FindShopsRequest;
import com.honeybadgersoftware.shoplocation.model.response.NearbyShopsIdsResponse;
import com.honeybadgersoftware.shoplocation.service.ShopLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ShopLocationFacade {

    private final ShopLocationService shopLocationService;
    private final AzureMapsApi azureMapsApi;
    private final AzureResultToNamesStringsFactory namesStringFactory;

    public NearbyShopsIdsResponse getNearbyShopsIds(FindShopsRequest findShopsRequest) {

        List<Result> results = secureNullResponse(azureMapsApi.searchPoiCategory(
                findShopsRequest.getLatitude(),
                findShopsRequest.getLongitude(),
                findShopsRequest.getRadius()));


        if (results.isEmpty()) {
            return new NearbyShopsIdsResponse(Collections.emptyList());
        }

        return new NearbyShopsIdsResponse(shopLocationService.getShops(namesStringFactory.map(results)));
    }

    private List<Result> secureNullResponse(AzureShopsLocationResponse azureShopsLocationResponse) {

        if (azureShopsLocationResponse == null) {
            return Collections.emptyList();
        }

        List<Result> results = azureShopsLocationResponse.getResults();

        if (results == null) {
            return Collections.emptyList();
        }

        return results;
    }

}
