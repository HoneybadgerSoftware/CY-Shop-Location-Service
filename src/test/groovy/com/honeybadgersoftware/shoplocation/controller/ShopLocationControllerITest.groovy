package com.honeybadgersoftware.shoplocation.controller


import com.honeybadgersoftware.shoplocation.base.BaseIntegrationTest
import com.honeybadgersoftware.shoplocation.data.AzureResponseData
import com.honeybadgersoftware.shoplocation.model.FindShopsRequest
import com.honeybadgersoftware.shoplocation.model.response.NearbyShopsResponse
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
        wireMock.stubFor(get(urlEqualTo("/search/poi/category/json?lat=${lat}&lon=${lon}&radius=${radius}&api-version=1.0&query=supermarket&subscription-key=test"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(AzureResponseData.AzureResponse)
                        .withStatus(200))
        )

        and:
        FindShopsRequest request = new FindShopsRequest(lon, lat, radius)

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<FindShopsRequest> requestEntity = new HttpEntity<>(request, headers)

        when:
        ResponseEntity<NearbyShopsResponse> response = restTemplate.exchange(
                addressToUseForTests + "/location",
                HttpMethod.POST,
                requestEntity,
                NearbyShopsResponse.class)

        then:
        response.getStatusCode() == HttpStatus.OK
        response.getBody().data.get(0) == 4L

    }
}
