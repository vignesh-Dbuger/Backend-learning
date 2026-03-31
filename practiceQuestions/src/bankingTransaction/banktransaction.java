package bankingTransaction;
import java.util.*;
import java.io.*;

public class banktransaction {
	
		  public static void main(String[] args) throws Exception {
		        Scanner fs = new Scanner(System.in);
		        int n = Integer.parseInt(fs.next());
		 
		        Map<String, Long> bal = new HashMap<>();
		 
		        for (int i = 0; i < n; i++) {
		            String acc = fs.next();
		            String type = fs.next();
		            long amt = fs.nextLong();
		            if ("DEPOSIT".equals(type)) {
		            	bal.put(acc,bal.getOrDefault(acc, 0L)+amt);
		            } 
		            else {
		            	if(amt<=bal.get(acc)) {
		            		bal.put(acc,bal.get(acc)-amt);
		            	}
		            	
		            }
		        }
		        
		     List<Map.Entry<String, Long>> list=new ArrayList<>(bal.entrySet());
		     
		     list.sort((a,b)->{
		    	 int bybal=Long.compare(b.getValue(), a.getValue());
		    	 if(bybal!=0) return bybal;
		    	 return b.getKey().compareTo(a.getKey());
		     });
		     
		     for (var e : list) {
		            System.out.println(e.getKey() + " " + e.getValue());
		        }



		  }

}
