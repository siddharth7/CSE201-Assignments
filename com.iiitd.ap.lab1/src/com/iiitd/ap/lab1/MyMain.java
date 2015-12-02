package com.iiitd.ap.lab1;

public class MyMain {
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Employee e= new Employee();
		Employee b=(Employee) e.clone();
		b.bla[0]=10;
		System.out.println(b.bla[0]);
		System.out.println(e.bla[0]);
	}

}
