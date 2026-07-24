package com.example.SpringBootRESTClient4.controller;

import com.example.SpringBootRESTClient4.model.OrderRequestForm;
import com.example.SpringBootRESTClient4.model.OrderResponse;
import com.example.SpringBootRESTClient4.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders/v1")
public class RestController {

    @Autowired
    private RestClientService restClientService;


    /*URL : http://localhost:8192/orders/v1/getOrder4Client/Feb/red?parmRequestSource=web&parmAudienceType=external
	POST
	Header : Authorization 	 Basic YWJoaWtnaDp3ZWxjb21lQDFh
		     Actor  test
	Body:
	{
	  "orderId" : 100,
	  "location" : "Kolkata",
	  "invoiceType" : 2,
	  "orderItems" : [ {
	    "itemId" : 1001,
	    "itemName" : "iPhoneX",
	    "quantity" : 2
	  }, {
	    "itemId" : 1002,
	    "itemName" : "iPad",
	    "quantity" : 2
	  }, {
	    "itemId" : 1003,
	    "itemName" : "LED TV",
	    "quantity" : 2
	  } ]
     }
    */
    @PostMapping(value = "/getOrder4Client/{month}/{colour}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> getOrder4Client(
            @PathVariable(value = "month") String month,
            @PathVariable(value = "colour") String colour,
            @RequestParam(value = "parmRequestSource") String parmRequestSource,
            @RequestParam(value = "parmAudienceType", required = false) String parmAudienceType,
           @RequestBody OrderRequestForm orderRequestForm) throws Exception {

        OrderResponse orderResponse = restClientService.getOrder4Client(month, colour, parmRequestSource, parmAudienceType, orderRequestForm);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderResponse);
    }

    /*URL : http://localhost:8192/orders/v1/getOrder4Client/Feb/red?parmRequestSource=web&parmAudienceType=external
  POST
  Header : Authorization 	 Basic YWJoaWtnaDp3ZWxjb21lQDFh
           Actor  test
  Body:
  {
    "orderId" : 100,
    "location" : "Kolkata",
    "invoiceType" : 2,
    "orderItems" : [ {
      "itemId" : 1001,
      "itemName" : "iPhoneX",
      "quantity" : 2
    }, {
      "itemId" : 1002,
      "itemName" : "iPad",
      "quantity" : 2
    }, {
      "itemId" : 1003,
      "itemName" : "LED TV",
      "quantity" : 2
    } ]
   }
  */
    @PostMapping(value = "/getOrder42Client/{month}/{colour}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> getOrder42Client(
            @PathVariable(value = "month") String month,
            @PathVariable(value = "colour") String colour,
            @RequestParam(value = "parmRequestSource") String parmRequestSource,
            @RequestParam(value = "parmAudienceType", required = false) String parmAudienceType,
            @RequestBody OrderRequestForm orderRequestForm) throws Exception {

        OrderResponse orderResponse = restClientService.getOrder42Client(month, colour, parmRequestSource, parmAudienceType, orderRequestForm);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderResponse);
    }
}
