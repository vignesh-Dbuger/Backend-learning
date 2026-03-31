package com.flashsale.InventorySystem.Service;


import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashsale.InventorySystem.Entity.Orders;
import com.flashsale.InventorySystem.Entity.Products;
import com.flashsale.InventorySystem.repository.InventoryRepository;

@Service
public class InventoryService {
	
	private InventoryRepository rep;
	
	InventoryService(InventoryRepository rep){
		this.rep=rep;
	}
    
	private static Logger logger=LoggerFactory.getLogger(InventoryService.class);
	
	@Transactional
	public Orders BookOreder(int id, String email) {
		
	 List<Products> productlist=rep.getstock(id);
	 
	 if(productlist.isEmpty() || productlist.get(0).getCount()<=0) {
		  throw new RuntimeException("Product is not avilable");
	 }
	 
	   int StockCount=productlist.get(0).getCount();
	   
	   logger.info(String.valueOf(StockCount));
	 
      if(StockCount>0) {
    	  
    	  rep.UpdateStock(id,StockCount);
    	  
    	if( rep.createorder(email,id)==1) {
    		return rep.getorders(id);
    	}
      }
      return  new Orders();
	}

}
