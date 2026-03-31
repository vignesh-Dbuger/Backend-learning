package logAnalyzer;

import java.time.ZoneId;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		        Set<String> allZones = ZoneId.getAvailableZoneIds();
		        allZones.stream()
		        .filter(n->n=="Asia")
		        .forEach(System.out::println); 
	 }
 }
		
//		for(int i=0;i<=6;i++) {
//		 LocalTime	entertime=LocalTime.now();
//		 DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm");
//		 String time=entertime.format(format);
//		 String name=sr.next();
//		 Action action=Action.valueOf(sr.next().toUpperCase());
//		 Status status=Status.valueOf(sr.next().toUpperCase());
//		 list.add(new application(time,name,action,status));	
//		}
		
		



