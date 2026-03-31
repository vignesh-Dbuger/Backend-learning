package empSystem;

public  class salesemp extends Employee implements Bonuspolicy{
      private double salesamount;
	salesemp(String name, int age, int id, double salary) {
		super(name, age, id, salary);
	}  
	   @Override
	    public double calculatebonus(){
			return salesamount*0.10;
		}
	    @Override
	    public double calculatesalary() {
	    	return salary+calculatebonus();
	    }
}
