package studentdashboard;

import java.util.*;

public class StudentDetail {
	
  public static void main(String[] args) {
	 Scanner sr=new Scanner(System.in);
	    
	 Map<String,Integer> mp=new HashMap<>();
	 Map<String,Integer> mpcount=new HashMap<>();
	 
	 String topsubject=null;
	 int topmark=Integer.MIN_VALUE;
	  
	   int n=sr.nextInt();
	   for(int i=0;i<n;i++) {
		   String name=sr.next();
		   String subject=sr.next();
		   int mark=sr.nextInt();
		  
		mpcount.put(name,mpcount.getOrDefault(name,0)+1);
		mp.put(name,mp.getOrDefault(name,0)+mark);
		
		if(mark>topmark || (mark==topmark && (topsubject==null || subject.compareTo(topsubject)<0))) {
			topmark=mark;
			topsubject=subject;
		}	 
	   }
	   
	   List<studavg> list=new ArrayList<>();
	   
	   for(String s:mp.keySet()) {
		   double avg=mp.get(s)/mpcount.get(s);
		   if(avg>75) {
			   list.add(new studavg(s,avg));
		   }
		   
	   }
	   list.sort((a,b)->{
			  int byavg=Double.compare(b.avg, a.avg);
			  if(byavg!=0) return byavg;
		       return a.name.compareTo(b.name);
	 });
	   
	  for(studavg sa:list) {
		  System.out.printf(Locale.US,"%s%.1f%n",sa.name,sa.avg);  
	  }
	   System.out.println("top Subject"+topsubject);
	   
    }

  
  static class studavg{
	 String name;
	 double avg; 
	 
	 studavg(String name,double avg){
		 this.name=name;
		 this.avg=avg;
	 }
  }
}
  


