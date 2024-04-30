package com.honeybadgersoftware.shoplocation.client.maps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class POI {

    private String name;
    private List<Brand> brands;
}
