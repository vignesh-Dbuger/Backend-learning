package com.flashsale.InventorySystem.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	
	@JsonProperty("ProductId")
	int id;
	@JsonProperty("ProductName")
	String name;
	@JsonProperty("ProductPrice")
	int price;
	@JsonProperty("ProductCount")
	int count;
	
	

}
