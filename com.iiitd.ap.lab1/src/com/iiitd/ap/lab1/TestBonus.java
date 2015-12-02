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

//Sort Test Cases for Bonus Sort- Quick Sort with middle element as pivot
@RunWith(Enclosed.class)
public class TestBonus
{
	
@RunWith(Parameterized.class)
public static class TestSort_Int {

	Bonus_sort1<Integer> bs1=new Bonus_sort1<Integer>();
	private Integer[] intlist;

    
    public TestSort_Int(Integer[] intlist) {
    	this.intlist = intlist;
    }

	@Parameters
	 public static Collection test() {
		return Arrays.asList(new Integer[][][] {{{34, 17, 23, 35, 17, 45, 9, 1}},
				{{1, 2, 3, 4, 5, 6, 7, 8}},
				{{56, 44, 41, 34, 23, 18, 14, 11, 8, 4, 2}},
				{{12,3,34,8,1,2}}});
		
	}
	
	@Test
	public void sort_int()
	{//For array of integers
		
		Integer[] abc=bs1.Sort(intlist);
		
		 for (int j = 0; j < abc.length - 1; j++) {
	            if (abc[j] > abc[j + 1]) {
	              fail("Gives "+abc[j] +" before "+ abc[j + 1]);
	            }
	          }
		
				
	}

}


@RunWith(Parameterized.class)
public static class TestSort_String {


	Bonus_sort1<String> bs2=new Bonus_sort1<String>();
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
	public void sort_srt()
	{//For array of string
		
		String[] abc=bs2.Sort(strlist);
		
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
    
	Bonus_sort1<Double> bs3=new Bonus_sort1<Double>();
	

    
    public TestSort_Double(Double[] dblist) {
    	this.dblist = dblist;
    }

	@Parameters
	 public static Collection test() {
		return Arrays.asList(new Double[][][] {{{3.4,5.6,8.0,0.5,2.4,88.3,17.55}},
				{{4.4,7.8,12.2,16.6,34.5,77.4,86.5}},
				{{99.99,81.8634,78.32,54.36,35.75,24.67,17.54,3.87}},
				});
		
	}
	
	@Test
	public void sort_db()
	{//For array of double
		
		Double[] abc=bs3.Sort(dblist);
		
		 for (int j = 0; j < abc.length - 1; j++) {
	            if (abc[j] > abc[j + 1]) {
	              fail("Gives "+abc[j] +" before "+ abc[j + 1]);
	            }
	          }
		
				
	}

}


@RunWith(Parameterized.class)
public static class TestSwaps_Int {

private int expected, input;

Bonus_sort1<Integer> bs1=new Bonus_sort1<Integer>();
	Integer[][] intlist={{34, 17, 23, 35, 17, 45, 9, 1},
			{1, 2, 3, 4, 5, 6, 7, 8},
			{56, 44, 41, 34, 23, 18, 14, 11, 8, 4, 2},
			{12,3,34,8,1,2}};

    
    public TestSwaps_Int(int input,int expected) {
		this.expected = expected;
		this.input=input;
	
		
	}

	@Parameters
	 public static Collection swaps() {
		return Arrays.asList(new Integer[][] {{0,8},{1,0},{2,5},{3,3}});
		
	}
	@Test
	public void sort_int_swaps()
	{//For array of integers
		
		bs1.Sort(intlist[input]);
        assertEquals(bs1.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}


@RunWith(Parameterized.class)
public static class TestSwaps_String {

private int expected, input;

Bonus_sort1<String> bs2=new Bonus_sort1<String>();
	String[][] strlist={{"Jiggy"},
			{"Sammy","Bigu"},
			{"Mel","Appu","Aam","Delta Foo","Greece","Catherine"},
			{"Amy","Adam","Dorthy tee","Galileo"},
			{"Zack","Tiger Saw","Nigella","France","Edd","Bonjour","Anderson"}};

    
    public TestSwaps_String(int input,int expected) {
		this.expected = expected;
		this.input=input;
	
		
	}

	@Parameters
	 public static Collection swaps() {
		return Arrays.asList(new Integer[][] {{0,0},{1,1},{2,2},{3,1},{4,3}});
		
	}
	@Test
	public void sort_str_swaps()
	{//For array of string
		
		bs2.Sort(strlist[input]);
        assertEquals(bs2.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}

@RunWith(Parameterized.class)
public static class TestSwaps_Double {

private int expected, input;

Bonus_sort1<Double> bs3=new Bonus_sort1<Double>();
	Double[][] dblist= {{3.4,5.6,8.0,0.5,2.4,88.3,17.55},
			{4.4,7.8,12.2,16.6,34.5,77.4,86.5},
			{99.99,81.8634,78.32,54.36,35.75,24.67,17.54,3.87},
			};
    
    public TestSwaps_Double(int input,int expected) {
		this.expected = expected;
		this.input=input;
	
		
	}

	@Parameters
	 public static Collection swaps() {
		return Arrays.asList(new Integer[][] {{0,5},{1,0},{2,4}});
		
	}
	@Test
	public void sort_db_swaps()
	{//For array of double
		
		bs3.Sort(dblist[input]);
        assertEquals(bs3.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}


}
