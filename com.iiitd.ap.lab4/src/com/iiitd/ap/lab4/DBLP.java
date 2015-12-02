package com.iiitd.ap.lab4;
/*
 * Siddharth Singh
 * 2014105
 * 
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
public class DBLP {
	public ArrayList<String> reading(String name1)
	{
	BufferedReader buffr = null;
	String line;
	ArrayList<String> a = new ArrayList<>();
	try {

		buffr = new BufferedReader(new FileReader("./src/output.csv"));
		while ((line = buffr.readLine()) != null) 
		{
			String[] data = line.split(",");
			if(data[0].equals(name1))
			{
				a.add(data[1]);
			}
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return a; 
	}
	ArrayList<String> coauthored(String a, String b)
	{
		
		ArrayList<String> a1= new ArrayList<>();
		ArrayList<String> a2= new ArrayList<>();
		a1=reading(a);
		a2=reading(b);
		ArrayList<String> a3 = new ArrayList<String>(a1);
		a3.retainAll(a2);
		return a3;
		
		
	}
}

