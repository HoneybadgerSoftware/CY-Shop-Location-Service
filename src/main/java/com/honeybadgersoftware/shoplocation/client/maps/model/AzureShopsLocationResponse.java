package com.honeybadgersoftware.shoplocation.client.maps.model;

import lombok.Data;

import java.util.List;

@Data
public class AzureShopsLocationResponse {

    private Summary summary;
    private List<Result> results;

}
