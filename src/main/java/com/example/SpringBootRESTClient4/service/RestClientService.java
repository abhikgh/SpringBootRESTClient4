package com.example.SpringBootRESTClient4.service;

import com.example.SpringBootRESTClient4.model.OrderRequestForm;
import com.example.SpringBootRESTClient4.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;

@Service
public class RestClientService {

    @Autowired
    private RestClient restClient;

    public OrderResponse getOrder2Client(String month, String colour,
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
}
