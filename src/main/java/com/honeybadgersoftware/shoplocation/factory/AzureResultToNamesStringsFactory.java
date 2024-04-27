package com.honeybadgersoftware.shoplocation.factory;

import com.honeybadgersoftware.shoplocation.client.maps.model.Result;
import com.honeybadgersoftware.shoplocation.utils.OneToOneFactory;
import org.springframework.stereotype.Component;

@Component
public class AzureResultToNamesStringsFactory implements OneToOneFactory<Result, String> {

    @Override
    public String map(Result result) {
        return result.getPoi().getName();
    }
}
