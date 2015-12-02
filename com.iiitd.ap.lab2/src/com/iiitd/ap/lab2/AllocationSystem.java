package com.iiitd.ap.lab2;
/**
 * Siddarth Singh
 * 2014105
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class InvalidInputException extends Exception {
}

public class AllocationSystem {
	public static int required; 
	public static int maxu;
	public static int maxp;
	public static int maxphd;
	public static int tot=required;
	public AllocationSystem(int numb)
	{
		required=numb;
	}
	public static ArrayList<Applicant> getshortlist(ArrayList<Applicant> arr) throws InvalidInputException{
		if(required > arr.size())
		{
			throw new InvalidInputException();
		}
		
		int tot = required;
		ArrayList <Applicant> pg= new ArrayList<>();
		ArrayList <Applicant> ug= new ArrayList<>();
		ArrayList <Applicant> phd= new ArrayList<>();
		ArrayList <Applicant> flist= new ArrayList<>();
		ArrayList <Applicant> flist2= new ArrayList<>();


		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).program.equals("PG"))
				{
				pg.add(arr.get(i));
				}
			else if(arr.get(i).program.equals("UG"))
				ug.add(arr.get(i));
			else if(arr.get(i).program.equals("PhD"))
				phd.add(arr.get(i));
		}
		Collections.sort(pg);
//		for(int j=0;j<pg.size();j++)
//		{
//			Applicant q=pg.get(j);
//			System.out.println(q.CGPA);
//		}
		Collections.sort(ug);
		
		Collections.sort(phd);
		
		maxu=(required*3)/10;
		maxp=required/2;
		maxphd=required/2;
		int i=0;
		while(i<maxphd && i<phd.size())
		{
			flist.add(phd.get(i));
			i++;
		}	

			required=-i;
			required=+1;
		i=0;
		while(i<maxp && i<pg.size())
		{
			flist.add(pg.get(i));
			i++;
		}
			required-=i;
			required=+1;
		i=0;
		while(i<maxu && i<ug.size())
		{
			flist.add(ug.get(i));
			i++;
		
		}
			required-=i;
			required=+1;
		for(i=0;i<tot && i < flist.size();i++)
		{
			flist2.add(flist.get(i));
		}
		return flist2;
	}
	public static void main(String[] args)
{
		System.out.println((int)0.75);
		int run;
		run=1;
		System.out.println(run);
//		AllocationSystem abc= new AllocationSystem(2);
//		Applicant[] a = new Applicant[5];
//		a[0]=new Applicant("Madhur","MT1254","PG",7.8);
//	      a[1]=new Applicant("Megha","MT1354","PG",8.2);
//	      a[2]=new Applicant("Rani","1254","PhD",7.8);
//	      a[3]=new Applicant("Jay","2013054","UG",9.3);
//	      a[4]=new Applicant("Shabad","MT1554","PG",9.0);
//	    ArrayList<Applicant> i=getshortlist(a);
////	    System.out.println("adada");
//	    for(int x=0;x<i.size();x++)
//	    {
//		    Applicant af=i.get(x);
//	    	System.out.println(af.name);
//
//	    }
//	    
//	}
//
		}
}

