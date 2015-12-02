package com.iiitd.ap.lab1;

public class Employee implements Cloneable {
	public int salary;
	public String name;
	public int[] bla;
	
	public Employee()
	{
		bla= new int[10];
		bla[0]=100;
		name="sddsfs";
		salary=1000;
		
	}
	public Employee clone() throws CloneNotSupportedException
	{
		return (Employee)super.clone();
	}
}
