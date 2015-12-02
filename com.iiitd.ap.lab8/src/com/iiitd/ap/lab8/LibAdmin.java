package com.iiitd.ap.lab8;
/**
 * Siddharth Singh
 * 2014105
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LibAdmin{
	String username, password;
	int flag;
	HashMap<String, ArrayList<String>> book_data;
	LibAdmin()
	{
		this.username="admin";
		this.password="pass";
		this.flag=0;
		this.book_data=new HashMap<String, ArrayList<String>>();
		this.book_data.put("book1", new ArrayList<String>(Arrays.asList("12","13","14","15")));
		this.book_data.put("book2", new ArrayList<String>(Arrays.asList("22","23","24")));
		this.book_data.put("book3", new ArrayList<String>(Arrays.asList("32","33")));
		this.book_data.put("book4", new ArrayList<String>(Arrays.asList("42")));
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
	int is_available_by_id(String search_id)
	{
		if(this.book_data.containsKey(search_id))
		{
			if(this.book_data.get(search_id).size()>0)
				return 1;
			else
				return 0;
		}
		return 0;
	}
	int is_available_by_name(String search_id)
	{
		if(this.book_data.containsKey(search_id))
		{
			if(this.book_data.get(search_id).size()>0)
				return 1;
			else 
				return 0;
		}
		return 0;
	}
	String checkout_by_id(String search_id)
	{
		if(this.book_data.containsKey(search_id))
		{
			if(this.book_data.get(search_id).size()>0)
			{
				String book_id=this.book_data.get(search_id).get(0);
				this.book_data.get(search_id).remove(0);
				return book_id;
			}
		}
		return "sorry";
	}
	String checkout_by_name(String search_id)
	{
		if(this.book_data.containsKey(search_id))
		{
			if(this.book_data.get(search_id).size()>0)
			{
				String book_name=this.book_data.get(search_id).get(0);
				this.book_data.get(search_id).remove(0);
				return book_name;
			}
		}
		return "sorry";
	}
}
class Incorrect_Credentials_Exception extends Exception {

	private static final long serialVersionUID = 1L;

	public Incorrect_Credentials_Exception() {
		// TODO Auto-generated constructor stub
		super();
	}
}
