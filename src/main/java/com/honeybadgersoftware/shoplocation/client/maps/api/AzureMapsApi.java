package com.honeybadgersoftware.shoplocation.client.maps.api;

import com.honeybadgersoftware.shoplocation.client.maps.config.AzureMapsClientConfig;
import com.honeybadgersoftware.shoplocation.client.maps.model.AzureShopsLocationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "azure-maps", url = "${azure-maps.url}", configuration = AzureMapsClientConfig.class)
public interface AzureMapsApi {

    @GetMapping("/search/poi/category/json")
    AzureShopsLocationResponse searchPoiCategory(
            @RequestParam("lat") double latitude,
            @RequestParam("lon") double longitude,
            @RequestParam("radius") int radius);

}
