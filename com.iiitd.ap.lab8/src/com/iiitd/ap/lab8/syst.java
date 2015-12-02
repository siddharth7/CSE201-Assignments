package com.iiitd.ap.lab8;
/**
 * Siddharth Singh
 * 2014105
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class syst {
	public static HashMap<String, Person> global_map=new HashMap<String, Person>();
	public static Person[] user = new Person[100];
	int index=0;
	public static void main(String args[]) throws Incorrect_Credentials_Exception, IOException
	{
		LibAdmin adm = new LibAdmin();
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Login as:");
			System.out.println("1. for admin");
			System.out.println("2. for user");
			System.out.println("3.Exit");
			Person p1 = null;
			int choice = scan.nextInt();
			if (choice==1)
			{
				adm.login();
				if(adm.flag==1 )
				{
					while(true)
					{
						System.out.println("1. Show reserved copies");
						System.out.println("2. Logout");
						Scanner scan_choice= new Scanner(System.in);
						int choice2=scan_choice.nextInt();
							if(choice2==2)
							{
								adm.logout();
								break;
							}
							else if(choice2==1)
							{
								//show reserved copies
								for(Map.Entry<String, Person> entry : global_map.entrySet())
								{
									System.out.print(entry.getKey()+" has issued ");
									System.out.println(entry.getValue().issued_books);
								}
								
							}
					}
				}
			}
			else if(choice==2)
			{
				System.out.println("Enter Choice");
				while(true)
				{	
					System.out.println("1.Login");
					System.out.println("2.Register");
					System.out.println("3.Logout");
					System.out.println("4.Checkout");
					System.out.println("5.Search catalog");
					System.out.println("6.Release Item");
					System.out.println("7.exit");
					Scanner scan_ch= new Scanner(System.in);
					//global_map.put("user", new Person("user","passw"));
					int cho=scan_ch.nextInt();
					if(cho==1)
					{
						Scanner scan_credd = new Scanner(System.in);
						System.out.print("Username:");
						String user_id = scan_credd.nextLine();
						System.out.print("Password:");
						String user_pas= scan_credd.nextLine();
						try
						{
							p1= global_map.get(user_id);
							if(user_pas.equals(p1.password))
							{
								p1.flag=1;
								System.out.println("Logged in successfully");
								System.out.println("---------------------");
							}
							else
							{
								System.out.println("Check Account");
								System.out.println("---------------------");
							}
						}
						catch(Exception e)
						{
							System.out.println("No such User");
							System.out.println("---------------------");
						}
						
					}
					else if(cho==2)
					{
						int fl=0;
						while(fl==0)
						{
							System.out.println("Enter Id");
							System.out.println("---------------------");
							Scanner scan_new = new Scanner(System.in);
							String user_id=scan_new.nextLine();
							if(global_map.containsKey(user_id))
							{
								System.out.println("User already exists");
								System.out.println("---------------------");
							}
							else
							{
								System.out.println("Enter password");
								System.out.println("---------------------");
								String user_pas= scan_new.nextLine();
								global_map.put(user_id, new Person(user_id,user_pas));
								fl=1;
								System.out.println("User registered successfully");
								System.out.println("---------------------");
							}
						}
					}
					else if(cho==3)
					{
						if(p1==null)
						{
							System.out.println("no user logged in");
							System.out.println("---------------------");
						}
						else
						{
							System.out.println(p1.id + " is logged out now");
							System.out.println("---------------------");
							p1.logout();
							p1=null;
						}
					}
					else if(cho==4)
					{
						Scanner scan_book= new Scanner(System.in);
						//System.out.println("1.search by item number");
						System.out.println("2.search by book name");
						int ch_book= scan_book.nextInt();
//						if(ch_book==1)
//						{
//							Scanner scan_name= new Scanner(System.in);
//							String name=scan_name.nextLine();
//							int val= adm.is_available_by_id(name);
//							if(val==1)
//							{
//								adm.checkout_by_id(name);
//								System.out.println(name+" has been check out by you");
//								System.out.println("-------------");
//							}
//							else
//							{
//								System.out.println(name+" id out of stock");
//								System.out.println("-------------");
//							}
//						}
						if(ch_book==2)
						{
							Scanner scan_name= new Scanner(System.in);
							String name=scan_name.nextLine();
							int val= adm.is_available_by_name(name);
							if(val==1)
							{
								String b_name=adm.checkout_by_name(name);
								if(b_name.equals("sorry"))
								{
									System.out.println("cannot issue");
									System.out.println("-------------");
								}
								else
								{
									if(p1.issued_books.containsKey(name))
									{
										System.out.println("Already Issued");
										System.out.println("-------------");
									}
									else
									{
										p1.issued_books.put(name, b_name);
										System.out.println(name+" " + b_name+ " has been check out by you");
										System.out.println("-------------");
									}
								}
							}
							else
							{
								System.out.println(name+" id out of stock");
								System.out.println("-------------");
							}
						}
					}
					else if(cho==5)
					{
						for (Map.Entry<String, ArrayList<String>> entry : adm.book_data.entrySet()) {
						    String key = entry.getKey();
						    ArrayList<String> value = entry.getValue();
						    System.out.print(key);
						    System .out.println(" "+value);
						}
					}
					else if(cho==6)
					{
						if(p1.issued_books.size()==0)
							System.out.println("There is no book in your account");
						else
						{
							Scanner scan_book= new Scanner(System.in);
							String bok_n = scan_book.nextLine();
							int flg=0;
							System.out.println(p1.issued_books);
							for(Map.Entry<String, String> entry : p1.issued_books.entrySet())
							{
								String key= entry.getKey();
								String value = entry.getValue();
								if(key.equals(bok_n))
								{
									adm.book_data.get(key).add(value);
									p1.issued_books.remove(key);
									flg=1;
								}
							}
							if(flg==1)
								System.out.println("Item returned");
							else
								System.out.println("No such book in your account");
						}
					}
					else if(cho==7)
					{
						break;
					}
					
				}
				
			}
			else if(choice==3)
				System.exit(0);
		}
	}
}
