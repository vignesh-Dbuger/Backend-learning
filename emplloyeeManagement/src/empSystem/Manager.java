package empSystem;

public class Manager extends Employee implements Bonuspolicy{
	private double bonus;
	Manager(String name, int age, int id, double salary,double bonus) {
		super(name, age, id, salary);
		this.bonus=bonus;
	}
     
    @Override
    public double calculatebonus(){
		return bonus;
	}
    @Override
    public double calculatesalary() {
    	return salary+calculatebonus();
    }
    
}
