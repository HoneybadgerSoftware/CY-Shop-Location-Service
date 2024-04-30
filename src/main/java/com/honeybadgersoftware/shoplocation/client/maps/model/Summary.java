package com.honeybadgersoftware.shoplocation.client.maps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Summary {

    private int totalResults;
    private GeoBias geoBias;

}
