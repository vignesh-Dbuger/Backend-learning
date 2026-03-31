package inventorySystem;

import java.time.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Inventory {

	public static void main(String[] args) {
		 
	  LocalDate  date=LocalDate.parse("2024-01-01");
	  
	  Scanner sr=new Scanner(System.in);
	  int n=sr.nextInt();
	  Map<String,Integer>  map=new HashMap<>();	
	  List<detail>  userlist=new ArrayList<>();
	  for(int i=0;i<n;i++) {
		  String name=sr.next();
		  LocalDate curDate=LocalDate.parse(sr.next());
		  int qty=sr.nextInt();
		 if(!curDate.isBefore(date)) {
		 userlist.add(new detail(name,curDate,qty));
		 }
	  }
	  for(detail dt:userlist) {
		  map.put(dt.name, map.getOrDefault(dt.name, 0)+dt.qty);
	  }
	  List<Map.Entry<String, Integer>> list=map.entrySet().stream()
		  .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).collect(Collectors.toList());
	  
	  System.out.println(list);
	  
	}
	  

	}
	
	class detail{
		String name;
		LocalDate curdate;
		int qty;
		
		
		
	  detail(String name,LocalDate curdate,int qty){
		  this.name=name;
		  this.curdate=curdate;
		  this.qty=qty;
	  }
	}


