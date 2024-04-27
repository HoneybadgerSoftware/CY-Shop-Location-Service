package com.honeybadgersoftware.shoplocation.controller


import com.honeybadgersoftware.shoplocation.base.BaseIntegrationTest
import com.honeybadgersoftware.shoplocation.data.AzureResponseData
import com.honeybadgersoftware.shoplocation.model.FindShopsRequest
import com.honeybadgersoftware.shoplocation.model.response.NearbyShopsIdsResponse
import org.springframework.http.*

import static com.github.tomakehurst.wiremock.client.WireMock.*

class ShopLocationControllerITest extends BaseIntegrationTest {

    def "updateAvailability updates product when valid request"() {

        given:
        Long shopId = 1L
        Double lon = 54.233806
        Double lat = 23.665014
        Integer radius = 1000

        and:
        wireMock.stubFor(get(urlEqualTo("https://atlas.microsoft.com/search/poi/category/json"))
                .withQueryParam("lat", equalTo(lat.toString()))
                .withQueryParam("lon", equalTo(lon.toString()))
                .withQueryParam("radius", equalTo(radius.toString()))
                .withQueryParam("api-version", equalTo("1.0"))
                .withQueryParam("query", equalTo("supermarket"))
                .withQueryParam("subscriptionKey", equalTo("qmRnfkk9mMhYKuWn2GukBHTInE3OwpvbZGUlQ3NVvvk"))
                .willReturn(aResponse()
                        .withBody(AzureResponseData.AzureResponse)
                        .withStatus(200))
        )

        and:
        FindShopsRequest request = new FindShopsRequest(lon, lat, radius)

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<FindShopsRequest> requestEntity = new HttpEntity<>(request, headers)

        when:
        ResponseEntity<NearbyShopsIdsResponse> response = restTemplate.exchange(
                addressToUseForTests + "/location",
                HttpMethod.POST,
                requestEntity,
                NearbyShopsIdsResponse.class)

        then:
        response.getStatusCode() == HttpStatus.OK

    }
}
