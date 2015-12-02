package com.iiitd.ap.lab1;

import java.io.IOException;
import java.util.Scanner;
public class Factorial
{
	public static void main(String[] argg)
	{
		try{
		int n;
		Scanner scan= new Scanner(System.in);
		n=scan.nextInt();
		
		for(int i=n-1;i>=1;i--)
		{
			n=n*i;
		}
			System.out.println(n);
			int jj=n;
		}
		catch(Exception E)
		{
			System.out.println("exception found");
			E.printStackTrace();
		}
		
	}

}
