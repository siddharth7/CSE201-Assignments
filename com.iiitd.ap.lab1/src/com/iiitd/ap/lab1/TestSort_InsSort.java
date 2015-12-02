package com.iiitd.ap.lab1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Sort Test Cases for Insertion Sort
@RunWith(Enclosed.class)
public class TestSort_InsSort
{
	
@RunWith(Parameterized.class)
public static class TestSort_Int {

	InsertionSorting insertsort=new InsertionSorting();
	private Integer[] intlist;

    
    public TestSort_Int(Integer[] intlist) {
    	this.intlist = intlist;
    }

	@Parameters
	 public static Collection test() {
		return Arrays.asList(new Integer[][][] {{{34, 17, 23, 35, 17, 45, 9, 1}},
				{{1, 2, 3, 4, 5, 6, 7, 8}},
				{{56, 44, 41, 34, 23, 18, 14, 11, 8, 4, 2}},
				{{12,3,34,8,1,2}},
				{{2,18,6,15,9,8,10,3}},
				{{4,4,4,4,2,2,6,6,1,1}}});
		
	}
	
	@Test
	public void inssort_int()
	{//For array of integers
		
		Integer[] abc=insertsort.Sort(intlist);
		
		 for (int j = 0; j < abc.length - 1; j++) {
	            if (abc[j] > abc[j + 1]) {
	              fail("Gives "+abc[j] +" before "+ abc[j + 1]);
	            }
	          }
		
				
	}

}


@RunWith(Parameterized.class)
public static class TestSort_String {


	InsertionSorting insertsort=new InsertionSorting();
	private String[] strlist;

    
    public TestSort_String(String[] strlist) {
    	this.strlist = strlist;
    }
	

    
	@Parameters
	 public static Collection test() {
		return Arrays.asList(new String[][][] {{{"Jiggy"}},
				{{"Sammy","Bigu"}},
				{{"Mel","Appu","Aam","Delta Foo","Greece","Catherine"}},
				{{"Amy","Adam","Dorthy tee","Galileo"}},
				{{"Zack","Tiger Saw","Nigella","France","Edd","Bonjour","Anderson"}}});
		
	}
	
	@Test
	public void inssort_srt()
	{//For array of string
		
		String[] abc=insertsort.Sort(strlist);
		
		 for (int j = 0; j < abc.length - 1; j++) {
	            if (abc[j].compareTo(abc[j + 1])>0) {
	              fail("Gives "+abc[j] +" before "+ abc[j + 1]);
	            }
	          }
		
		
				
	}

}

@RunWith(Parameterized.class)
public static class TestSort_Double {


	Double[] dblist ;
    
	InsertionSorting insertsort=new InsertionSorting();
	

    
    public TestSort_Double(Double[] dblist) {
    	this.dblist = dblist;
    }

	@Parameters
	 public static Collection test() {
		return Arrays.asList(new Double[][][] {{{3.4,5.6,8.0,0.5,2.4,88.3,17.55}},
				{{4.4,7.8,12.2,16.6,34.5,77.4,86.5}},
				{{99.99,81.8634,78.32,54.36,35.75,24.67,17.54,3.87}},
				{{}}});
		
	}
	
	@Test
	public void inssort_db()
	{//For array of double
		
		Double[] abc=insertsort.Sort(dblist);
		
		 for (int j = 0; j < abc.length - 1; j++) {
	            if (abc[j] > abc[j + 1]) {
	              fail("Gives "+abc[j] +" before "+ abc[j + 1]);
	            }
	          }
		
				
	}

}

}
