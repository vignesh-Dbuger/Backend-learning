package com.flashsale.InventorySystem.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flashsale.InventorySystem.Entity.Orders;
import com.flashsale.InventorySystem.Entity.Products;

@Repository
@PropertySource("classpath:Userquires.sql")
public class InventoryRepository {

	private NamedParameterJdbcTemplate namedtemplate;
	
	InventoryRepository (NamedParameterJdbcTemplate namedtemplate){
		this.namedtemplate=namedtemplate;
	}
	
	
	@Value("${fetchquery}")
	private String fetchquery;
	
	@Value("${updatequery}")
	private String updatequery;
	
	@Value("${ordercreate}")
	private String orderinsert;
	
	@Value("${fetchorder}")
	private String fetchorder;
	
	public List<Products> getstock(int id) {
		
		MapSqlParameterSource map=new MapSqlParameterSource();	
		map.addValue("id",id);
		
		RowMapper<Products> getproducts=(rs,rowNum)->{
		  return new Products(
					 rs.getInt("product_id"),
					 rs.getString("product_name"),
					 rs.getInt("price"),
					 rs.getInt("stock_count")
					 );
		};
		
		return namedtemplate.query(fetchquery, map,getproducts);
		
		
	}

	public int UpdateStock(int id,int count) {
		
		MapSqlParameterSource map=new MapSqlParameterSource();
		map.addValue("id", id)
		.addValue("count", count);
		
		return namedtemplate.update(updatequery, map);
	}

	public int createorder(String email,int id) {
		
		MapSqlParameterSource map=new MapSqlParameterSource();	
		map.addValue("email",email)
		   .addValue("id",id);
		
	  return namedtemplate.update(orderinsert,map);
	}

	public Orders getorders(int id) {
		
	 MapSqlParameterSource map=new MapSqlParameterSource();
	 map.addValue("id", id);
	 
	 RowMapper<Orders> getorder=(rs,rowNum)->{
		 return new Orders(
				 rs.getInt("order_id"),
				 rs.getString("customer_email"),
				 rs.getInt("product_id"),
				 rs.getTimestamp("order_timestamp").toLocalDateTime()
				 );
	 };
	 
	 return namedtemplate.queryForObject(fetchorder, map, new BeanPropertyRowMapper<>(Orders.class));
		
	}
  
	
}
