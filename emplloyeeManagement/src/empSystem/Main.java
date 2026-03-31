package empSystem;

public class Main {
	public static void main(String[] args) {
		Employee e1=new regularemployee("vikcy",18,101,10000);
		 e1.displyinfo();
		Employee m1=new Manager("sijo",30,001,1000000,5000);
		m1.displyinfo();
	}

}
