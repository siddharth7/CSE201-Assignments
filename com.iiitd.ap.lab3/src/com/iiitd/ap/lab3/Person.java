package com.iiitd.ap.lab3;
/*
 * siddharth singh
 * 2014105
 */
import java.io.IOException;
import java.util.ArrayList;

public class Person {
	 String name;
	Login_details log;
	ArrayList<Person> nn=new ArrayList<Person>();
	public Person(String n,String u,String p) {
		this.name=n;
		log= new Login_details(u, p);
		SocialNetwork.global_map.put(this,nn);
		// TODO Auto-generated constructor stub	
	}
	void addFriend(Person p)
	{
		//SocialNetwork.global_map.get(this).add(p);
		if(this.log.isloggedin())
		{
			
			if(!this.nn.contains(p))
			{
			SocialNetwork.global_map.get(this).add(p);
			}
			if(!p.nn.contains(this))
				SocialNetwork.global_map.get(p).add(this);
		}
		else
		{
			System.out.println(this.name+" is expected to login");
			try {
				this.log.login();
				addFriend(p);
			} catch (Incorrect_Credentials_Exception | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	ArrayList<String> get_mutual_friends(Person p)
	{
		ArrayList<String> mutualf = new ArrayList<String>();

		if(this.log.isloggedin())
		{
			ArrayList<Person> f1 = SocialNetwork.global_map.get(this);
			ArrayList<Person> f2 = SocialNetwork.global_map.get(p);

			for(int i=0;i<f1.size();i++)
			{
				for(int j=0;j<f2.size();j++)
				{
					if((f1.get(i).name).equals(f2.get(j).name))
					{
						mutualf.add(f1.get(i).name);
					}
				}
			}
		}
		else
		{
			System.out.println(this.name+" is expected to login");
			try {
				this.log.login();
				get_mutual_friends(p);
			} catch (Incorrect_Credentials_Exception | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mutualf;
	}
	ArrayList<String> getFriendList()
	{
		ArrayList<String> names = new ArrayList<>();
		if(this.log.isloggedin())
		{
			for(int i=0;i<SocialNetwork.global_map.get(this).size();i++)
			{
				names.add(SocialNetwork.global_map.get(this).get(i).name);
			}
		}
	else
	{
		System.out.println(this.name+" is expected to login");
		try {
			this.log.login();
			getFriendList();
		} catch (Incorrect_Credentials_Exception | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
			

		return names;
	}
	String getName()
	{
		return this.name;
	}
	void setName(String S)
	{
		if(this.log.isloggedin())

			{ 
				this.name=S;
			}
		else
		{	
			System.out.println(this.name+" is expected to login");
			try {
				this.log.login();
				setName(S);
			} catch (Incorrect_Credentials_Exception | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	}
}