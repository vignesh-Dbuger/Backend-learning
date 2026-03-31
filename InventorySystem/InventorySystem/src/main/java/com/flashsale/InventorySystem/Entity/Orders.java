package com.flashsale.InventorySystem.Entity;

import java.time.Instant;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@JsonProperty("OrderId")
	int orderid;
	@JsonProperty("OrderEmail")
	String name;
	@JsonProperty("ProductId")
	int  productid;
	@JsonProperty("OrderTimeStamp")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime OrderTime;
	
	

}
