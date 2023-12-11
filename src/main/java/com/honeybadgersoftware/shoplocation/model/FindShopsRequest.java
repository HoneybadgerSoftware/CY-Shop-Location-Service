package com.honeybadgersoftware.shoplocation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindShopsRequest {
    private Double longitude;
    private Double latitude;
    private Integer radius;
}
