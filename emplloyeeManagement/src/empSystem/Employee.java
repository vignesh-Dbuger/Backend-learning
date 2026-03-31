package empSystem;

abstract public class Employee extends person {
     private int empId;
     protected double salary;
     
	Employee(String name, int age,int id,double salary) {
		super(name, age);
		this.empId=id;
		if(salary>=0)
		   this.salary=salary;
		else System.out.println("enter valid amount");	
	}
	public double getSalary() {
		return this.salary;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public abstract double calculatesalary();
	
	public void displyinfo() {
		disply();
		System.out.println("empid : "+empId);
		System.out.println("salary : "+calculatesalary());
	}
}
