package com.example.SpringBootRESTClient4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "orderId",
    "location",
    "invoiceType",
    "orderItems"
})
public class OrderRequestForm implements Serializable {

	@JsonProperty(value = "orderId" ,required = true)
	@JsonPropertyDescription("orderId")
	private Integer orderId;
	
	@JsonProperty(value = "location")
	@JsonPropertyDescription("location")
	private String location;
	
	@JsonProperty( value = "invoiceType", required = true)
	@JsonPropertyDescription("invoiceType")
	private Integer invoiceType;

	@JsonProperty( value = "orderItems", required = true)
	@JsonPropertyDescription("orderItems")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class OrderItem{
		private int itemId;
		private String itemName;
		private int quantity;
	}

}
