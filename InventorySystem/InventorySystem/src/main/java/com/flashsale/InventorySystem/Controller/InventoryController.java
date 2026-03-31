package com.flashsale.InventorySystem.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashsale.InventorySystem.Entity.Orders;
import com.flashsale.InventorySystem.Service.InventoryService;

@RestController
@RequestMapping("/api/flash-sale")
public class InventoryController {
    
	private InventoryService service;
	
	InventoryController(InventoryService service){
		this.service=service;
	}
	
	@GetMapping("/buy")
	public Orders BookOrder(@RequestParam int id,@RequestParam String email) {
		
		return service.BookOreder(id,email);
	}
}
