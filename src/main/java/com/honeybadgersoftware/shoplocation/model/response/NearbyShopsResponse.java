package com.honeybadgersoftware.shoplocation.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NearbyShopsResponse {

    private List<ShopDto> data;

}
