package com.honeybadgersoftware.shoplocation.facade;

import com.honeybadgersoftware.shoplocation.client.maps.api.AzureMapsApi;
import com.honeybadgersoftware.shoplocation.client.maps.model.AzureShopsLocationResponse;
import com.honeybadgersoftware.shoplocation.client.maps.model.Result;
import com.honeybadgersoftware.shoplocation.factory.AzureResultToNamesStringsFactory;
import com.honeybadgersoftware.shoplocation.model.FindShopsRequest;
import com.honeybadgersoftware.shoplocation.model.response.NearbyShopsResponse;
import com.honeybadgersoftware.shoplocation.service.ShopLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ShopLocationFacade {

    private final ShopLocationService shopLocationService;
    private final AzureMapsApi azureMaps;
    private final AzureResultToNamesStringsFactory namesStringFactory;

    public NearbyShopsResponse getNearbyShopsIds(FindShopsRequest findShopsRequest) {

        AzureShopsLocationResponse azureShopsLocationResponse = azureMaps.searchPoiCategory(
                findShopsRequest.getLatitude(),
                findShopsRequest.getLongitude(),
                findShopsRequest.getRadius());

        List<Result> results = secureNullResponse(azureShopsLocationResponse);


        if (results.isEmpty()) {
            return new NearbyShopsResponse(Collections.emptyList());
        }

        return new NearbyShopsResponse(shopLocationService.getShops(namesStringFactory.map(results)));
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
