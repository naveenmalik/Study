package com.nav.test;

public class Employee implements Cloneable{
	
	public String name;
	private String dept;
	public Employee emp ;
	
	Employee(String name, String dept, Employee emp){
		this.name = name;
		this.dept = dept;
		this.emp = emp;
	}
	
	public String toString(){
		return "Name:"+ this.name +":: Dept:"+ this.dept + ":: Employee:" + this.emp;
	}
	
	public Object clone(){
		
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "Naveen";
		String dept = "IT";
		Employee temp = new Employee(name, dept, null);
		
		temp.emp = new Employee("Sakshi", "EDU", null);
		System.out.println(temp);
		
		Employee cloned = null;
		cloned = (Employee)temp.clone();
		
		temp.emp.name="Sakshi Hooda";
	
		System.out.println("Cloned" + cloned);
		
		System.out.println( "Original" + temp);
		

	}

}
