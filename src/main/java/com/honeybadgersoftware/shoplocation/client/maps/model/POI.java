package com.honeybadgersoftware.shoplocation.client.maps.model;

import lombok.Data;

import java.util.List;

@Data
public class POI {

    private String name;
    private List<Brand> brands;
}
