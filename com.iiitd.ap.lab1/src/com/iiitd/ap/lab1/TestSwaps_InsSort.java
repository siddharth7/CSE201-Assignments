package com.iiitd.ap.lab1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Swap Test Cases for Insertion Sort
@RunWith(Enclosed.class)
public class TestSwaps_InsSort
{
	
@RunWith(Parameterized.class)
public static class TestSwaps_Int {

private int expected, input;

	InsertionSorting insertsort=new InsertionSorting();
	Integer[][] intlist={{34, 17, 23, 35, 17, 45, 9, 1},
			{1, 2, 3, 4, 5, 6, 7, 8},
			{56, 44, 41, 34, 23, 18, 14, 11, 8, 4, 2},
			{12,3,34,8,1,2},
			{2,18,6,15,9,8,10,3},
			{4,4,4,4,2,2,6,6,1,1}};

    
    public TestSwaps_Int(int input,int expected) {
		this.expected = expected;
		this.input=input;
	
		
	}

	@Parameters
	 public static Collection swaps() {
		return Arrays.asList(new Integer[][] {{0,18},{1,0},{2,55},{3,11},{4,15},{5,24}});
		
	}
	@Test
	public void inssort_int_swaps()
	{//For array of integers
		
		insertsort.Sort(intlist[input]);
        assertEquals(insertsort.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}


@RunWith(Parameterized.class)
public static class TestSwaps_String {

private int expected, input;

	InsertionSorting insertsort=new InsertionSorting();
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
		return Arrays.asList(new Integer[][] {{0,0},{1,1},{2,8},{3,1},{4,21}});
		
	}
	@Test
	public void inssort_str_swaps()
	{//For array of string
		
		insertsort.Sort(strlist[input]);
        assertEquals(insertsort.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}

@RunWith(Parameterized.class)
public static class TestSwaps_Double {

private int expected, input;

	InsertionSorting insertsort=new InsertionSorting();
	Double[][] dblist= {{3.4,5.6,8.0,0.5,2.4,88.3,17.55},
			{4.4,7.8,12.2,16.6,34.5,77.4,86.5},
			{99.99,81.8634,78.32,54.36,35.75,24.67,17.54,3.87},
			{}};
    
    public TestSwaps_Double(int input,int expected) {
		this.expected = expected;
		this.input=input;
	
		
	}

	@Parameters
	 public static Collection swaps() {
		return Arrays.asList(new Integer[][] {{0,7},{1,0},{2,28},{3,0}});
		
	}
	@Test
	public void inssort_db_swaps()
	{//For array of double
		
		insertsort.Sort(dblist[input]);
        assertEquals(insertsort.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}

}
