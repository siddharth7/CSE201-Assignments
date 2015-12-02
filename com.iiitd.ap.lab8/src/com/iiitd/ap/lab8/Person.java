package com.iiitd.ap.lab8;
/**
 * Siddharth Singh
 * 2014105
 */
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Person{
	String id;
	String password;
	int flag;
	ConcurrentHashMap<String, String> issued_books;
	Person(String usern, String passw)
	{
		this.id=usern;
		this.password=passw;
		this.flag=0;
		this.issued_books= new ConcurrentHashMap<String, String>();
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
		Scanner scan = new Scanner(System.in);
		String u,p;
		System.out.print("Id:");
		u=scan.nextLine();
		System.out.print("Pin:");
		p=scan.nextLine();
		if(u==this.id && p==this.password)
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
}
