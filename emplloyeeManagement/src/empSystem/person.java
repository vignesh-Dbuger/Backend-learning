package empSystem;

public class person {
     private  String Name;
     private   int Age;
     
     person(String name,int age){
    	 this.Name=name;
    	 if(age>=18)
    	 this.Age=age;
    	 else System.out.println("enter valid age");
     }
     public void disply() {
    	 System.out.println("Name: "+Name+","+"Age :"+Age);
     }
	 
	   
}
