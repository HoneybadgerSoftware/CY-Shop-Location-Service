package com.honeybadgersoftware.shoplocation.client.maps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AzureShopsLocationResponse {

    private Summary summary;
    private List<Result> results;

}
