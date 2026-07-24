package com.example.SpringBootRESTClient4.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor //required for deserialization
public class OrderResponse {

	@JsonProperty
	private Integer orderId;
	@JsonProperty
	private String location;
	@JsonProperty
	private Integer invoiceType;
	@JsonProperty
	private String greetMessage="Thanks for ordering";
	@JsonProperty
	private Integer total;
	@JsonProperty
	private String parmRequestSource;
	@JsonProperty
	private String parmAudienceType;
	@JsonProperty
	private String month;
	@JsonProperty
	private String actor;
	@JsonProperty
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	@Getter
	@Setter
	public static class OrderItem{
		private int itemId;
		private String itemName;
		private int quantity;
		private int subTotal;
	}
}
