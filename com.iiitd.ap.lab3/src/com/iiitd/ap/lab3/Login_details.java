package com.iiitd.ap.lab3;
/*
 * siddharth singh
 * 2014105
 */
import java.util.Scanner;

public class Login_details {
	int flag;
	 String password;
	 String username;
	private Scanner scan;
	private Scanner scan2;
	Login_details(String usern, String passw) {
		// TODO Auto-generated constructor stub
		this.username=usern;
		this.password=passw;
		this.flag=1;
	}
	boolean isloggedin()
	{
		if (flag==0)
			return false;
		else 
			return true;
	}
	void login() throws Incorrect_Credentials_Exception,java.io.IOException

	{
		scan = new Scanner(System.in);
		String u,p;
		System.out.print("Username:");
		u=scan.nextLine();
		System.out.print("Password:");
		p=scan.nextLine();
		if(u.equals(this.username) && p.equals(this.password))
		{
			this.flag=1;
		}
		else
			this.flag=0;
		
	}
	void logout()
	{
		this.flag=0;
	}
	boolean verify_login()
	{
		scan2 = new Scanner(System.in);
		String u,p;
		u=scan2.nextLine();
		p=scan2.nextLine();
		if(u==this.username && p==this.password)
		{
			return true;
		}
		else
			return false;
	}
	
}
class Incorrect_Credentials_Exception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Incorrect_Credentials_Exception() {
		// TODO Auto-generated constructor stub
		super();
	}
}

