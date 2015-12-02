package com.iiitd.ap.lab3;
import java.util.HashMap;
import java.util.ArrayList;


public class SocialNetwork {

	public static HashMap<Person,ArrayList<Person>> global_map=new HashMap<Person,ArrayList<Person>>();


	public static void main(String args[])
	{
		/*
		 * Creation of Person objects implies creation of
		 * user accounts with the Constructor arguments as
		 * name, username and password
		 * On creation of account/object the person is assumed
		 * to be logged in until the person object logs out
		 */
		
		Person p1=new Person("Siddharth","sid","sid");
		Person p2=new Person("Amit","amit","qwerty");
		Person p3=new Person("Samit","sam","sam");
		Person p4=new Person("Arun","ar","helloworld");
		Person p5=new Person("Harsh","har","har123");
		
		
		try {

		p1.addFriend(p2);
		p1.addFriend(p3);
		p1.addFriend(p5);
		p1.log.logout();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		p2.addFriend(p4);
		p2.addFriend(p5);
		
		p5.log.logout();
		try
		{
		p5.addFriend(p2);
		p5.addFriend(p3);
		p5.addFriend(p4);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		p1.getFriendList();
		System.out.println("Friends of "+p1.getName()+":"+p1.getFriendList());
		System.out.println("Mutual friends of "+p1.getName()+" and "+p5.getName()+":"+p1.get_mutual_friends(p5).toString());
		System.out.println("Mutual friends of "+p1.getName()+" and "+p2.getName()+":"+p1.get_mutual_friends(p2).toString());

	}

}
