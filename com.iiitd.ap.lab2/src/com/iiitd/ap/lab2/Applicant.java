package com.iiitd.ap.lab2;
/**
 * Siddarth Singh
 * 2014105
 */
import java.util.ArrayList;

//@siddharth singh
//@2014105
public class Applicant implements Comparable<Applicant> {
	public String name;
	public String program;
	public String id;
	public double CGPA;
	public Applicant(String n, String i,String p, double c)
	{
		name=n;
		program=p;
		id=i;
		CGPA=c;
	}
	public double getgpa()
	{
		return CGPA;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getid() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCGPA() {
		return CGPA;
	}
	public void setCGPA(double cGPA) {
		CGPA = cGPA;
	}
	public static void main(String[] args)
	{
		//Applicant a=new Applicant("Madhur","MT1254","PG",7.8);
		//System.out.println(a.name);
	}
	@Override
	public int compareTo(Applicant o) {
		// TODO Auto-generated method stub
		if(this.CGPA<o.CGPA)
			return 1;
		else if(this.CGPA>o.CGPA)
			return -1;
		else
			return 0;
//		return (int) (this.CGPA - o.CGPA);
		//return this.CGPA.compareTo(o.getgpa());
	}
}
