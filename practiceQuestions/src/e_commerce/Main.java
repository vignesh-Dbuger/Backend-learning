package e_commerce;

import java.util.*;

public class Main {

	public static void main(String[] args) {
	
	Order_detail order1=new Order_detail(1 ,"Selva", "Pen", 2, 10);
	Order_detail order2=new Order_detail(2 ,"Arun", "Book", 1, 50);
	Order_detail order3=new Order_detail(3 ,"Selva", "Book", 3, 50);
	Order_detail order4=new Order_detail(4 ,"Bala", "Pen", 5, 10);
	Order_detail order5=new Order_detail(5 ,"Selva", "Pen", 4, 10);
	
	Map<String,Integer> mp=new HashMap<>();
	
	List<Order_detail> ol=Arrays.asList(order1,order2,order3,order4,order5);
	for(Order_detail order:ol) {
		mp.put(order.customerName,mp.getOrDefault(order.customerName,0)+order.qty*order.price);
	}
    
	List<Map.Entry<String, Integer>>  al=new ArrayList<>(mp.entrySet());
//	  al.sort((a,b)->b.getValue().compareTo(a.getValue()));
	  
	  al.sort(Comparator.comparingLong(Map.Entry<String, Integer>::getValue)
              .reversed()
              .thenComparing(Map.Entry::getKey));
	  
	 //1
	 System.out.println(al);
	 
	 //2
	 for(int i=0;i<3;i++) {
		 System.out.println(al.get(i));
	 }
	 
	 //3
	 Map<String,Integer> productmap=new HashMap<>();
	 for(Order_detail order:ol) {
			productmap.put(order.ProductName,mp.getOrDefault(order.ProductName,0)+order.qty);
     	}
	 
	 List<Map.Entry<String, Integer>>  pl=new ArrayList<>(productmap.entrySet());
	  pl.sort((a,b)->b.getValue().compareTo(a.getValue()));
	  
	  System.out.println(pl);
	}
}

