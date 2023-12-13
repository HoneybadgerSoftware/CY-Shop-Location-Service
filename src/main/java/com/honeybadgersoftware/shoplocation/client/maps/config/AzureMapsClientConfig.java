package com.honeybadgersoftware.shoplocation.client.maps.config;


import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureMapsClientConfig {

    @Value("${azure.maps.api.version}")
    private String apiVersion;

    @Value("${azure.maps.query}")
    private String query;

    @Value("${azure.maps.api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.query("api-version", apiVersion);
            requestTemplate.query("query", query);
            requestTemplate.query("subscription-key", apiKey);
        };
    }

}
