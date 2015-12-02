package com.iiitd.ap.lab1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Swap Test Cases for Selection Sort
@RunWith(Enclosed.class)
public class TestSwaps_SelSort
{
	
@RunWith(Parameterized.class)
public static class TestSwaps_Int {

private int expected, input;

	SelectionSorting selectsort=new SelectionSorting();
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
		return Arrays.asList(new Integer[][] {{0,5},{1,0},{2,5},{3,3},{4,3},{5,6}});
		
	}
	@Test
	public void selsort_int_swaps()
	{//For array of integers
		
        selectsort.Sort(intlist[input]);
        assertEquals(selectsort.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}


@RunWith(Parameterized.class)
public static class TestSwaps_String {

private int expected, input;

	SelectionSorting selectsort=new SelectionSorting();
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
	public void selsort_str_swaps()
	{//For array of string
		
        selectsort.Sort(strlist[input]);
        assertEquals(selectsort.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}

@RunWith(Parameterized.class)
public static class TestSwaps_Double {

private int expected, input;

	SelectionSorting selectsort=new SelectionSorting();
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
		return Arrays.asList(new Integer[][] {{0,5},{1,0},{2,4},{3,0}});
		
	}
	@Test
	public void selsort_db_swaps()
	{//For array of double
		
        selectsort.Sort(dblist[input]);
        assertEquals(selectsort.swaps,expected);
        //System.out.println("int:"+selectsort.swaps);
		
		
	}

}

}
