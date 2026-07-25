package com.example.SpringBootRESTClient4.service;

import com.example.SpringBootRESTClient4.model.OrderRequestForm;
import com.example.SpringBootRESTClient4.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestClientService {

    @Autowired
    private RestClient restClient;

    public OrderResponse getOrder4Client(String month, String colour,
                                         String parmRequestSource,
                                         String parmAudienceType,
                                         @RequestBody OrderRequestForm orderRequestForm) {
        return
                restClient
                        .post()
                        .uri("/getOrder4/"+month+"/"+colour+"?parmRequestSource="+parmRequestSource+"&parmAudienceType="+parmAudienceType)
                        .accept(MediaType.APPLICATION_JSON)
                        .body(orderRequestForm)
                        .header("Authorization", "Basic YWJoaWtnaDp3ZWxjb21lQDFh")
                        .header("Actor", "test")
                        .retrieve()
                        .body(OrderResponse.class);
    }

    public OrderResponse getOrder42Client(String month, String colour,
                                         String parmRequestSource,
                                         String parmAudienceType,
                                         @RequestBody OrderRequestForm orderRequestForm) {
        String endpoint = "http://localhost:8092/orders/v1/getOrder4/{month}/{colour}";

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("month", month);
        pathParams.put("colour", colour);

        URI uri = UriComponentsBuilder
                .fromUriString(endpoint)
                .queryParam("parmRequestSource", parmRequestSource)
                .queryParam("parmAudienceType", parmAudienceType)
                .buildAndExpand(pathParams)
                .encode()
                .toUri();

        return
                restClient
                        .post()
                        .uri(uri)
                        .accept(MediaType.APPLICATION_JSON)
                        .body(orderRequestForm)
                        .header("Authorization","Basic YWJoaWtnaDp3ZWxjb21lQDFh")
                        .header("Actor", "test")
                        .retrieve()
                        .body(OrderResponse.class);

    }

    public OrderResponse getOrder43Client(String month, String colour,
                                          String parmRequestSource,
                                          String parmAudienceType,
                                          @RequestBody OrderRequestForm orderRequestForm) {
        String endpoint = "http://localhost:8092/orders/v1/getOrder4/{month}/{colour}";

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("parmRequestSource", parmRequestSource);
        queryParams.put("parmAudienceType", parmAudienceType);

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("month", month);
        pathParams.put("colour", colour);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(endpoint);
        queryParams.forEach(uriComponentsBuilder::queryParam);

        return
                restClient
                        .post()
                        .uri(uriComponentsBuilder.encode().toUriString(), pathParams)
                        .accept(MediaType.APPLICATION_JSON)
                        .body(orderRequestForm)
                        .header("Authorization","Basic YWJoaWtnaDp3ZWxjb21lQDFh")
                        .header("Actor", "test")
                        .retrieve()
                        .body(OrderResponse.class);

    }

    public OrderResponse getOrder44Client(String month, String colour,
                                          String parmRequestSource,
                                          String parmAudienceType,
                                          @RequestBody OrderRequestForm orderRequestForm) {
        String endpoint = "/getOrder4/{month}/{colour}";

        var queryParams = CollectionUtils.toMultiValueMap(Map.of("parmRequestSource", Collections.singletonList(parmRequestSource),
                "parmAudienceType", Collections.singletonList(parmAudienceType)));

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("month", month);
        pathParams.put("colour", colour);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.putAll(CollectionUtils.toMultiValueMap(Map.of("Authorization", Collections.singletonList("Basic YWJoaWtnaDp3ZWxjb21lQDFh"), "Actor", Collections.singletonList("test"))));

        return
                restClient
                        .post()
                        .uri(UriComponentsBuilder.fromUriString(endpoint).queryParams(queryParams).encode().toUriString(), pathParams)
                        .accept(MediaType.APPLICATION_JSON)
                        .body(orderRequestForm)
                        .headers(httpHeader -> httpHeader.addAll(httpHeaders))
                        .retrieve()
                        .body(OrderResponse.class);

    }
}
