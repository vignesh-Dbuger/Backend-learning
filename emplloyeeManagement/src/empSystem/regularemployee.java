package empSystem;

public class regularemployee extends Employee {

	regularemployee(String name, int age, int id, double salary) {
		super(name, age, id, salary);

	}

	@Override
	public double calculatesalary() {
		return salary;
	}
	

}
