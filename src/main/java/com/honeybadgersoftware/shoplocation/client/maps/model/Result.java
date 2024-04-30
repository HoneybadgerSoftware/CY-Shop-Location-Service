package com.honeybadgersoftware.shoplocation.client.maps.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private double dist;
    private POI poi;

}
