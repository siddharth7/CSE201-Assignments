package com.iiitd.ap.lab1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * 
 * @author devika
 *
 */

/** Do not make any changes to this file
 * Prepare the two sorting classes according to this Test File **/

public class SortTest {

/*
 * Test Arrays for different data types 
 */
	Integer[][] intlist={{34, 17, 23, 35, 17, 45, 9, 1},
						{1, 2, 3, 4, 5, 6, 7, 8},
						{56, 44, 41, 34, 23, 18, 14, 11, 8, 4, 2},
						{12,3,34,8,1,2}};
	
    String[][] strlist={{"Jiggy"},
    					{"Sammy","Bigu"},
    					{"Mel","Appu","Aam","Delta Foo","Greece","Catherine"},
    					{"Amy","Adam","Dorthy tee","Galileo"},
    					{"Zack","Tiger Saw","Nigella","France","Edd","Bonjour","Anderson"}};
    
    Double[][] dblist= {{3.4,5.6,8.0,0.5,2.4,88.3,17.55},
    					{4.4,7.8,12.2,16.6,34.5,77.4,86.5},
    					{99.99,81.8634,78.32,54.36,35.75,24.67,17.54,3.87}};

    /*
     * Expected maximum swaps to sort the Test Arrays 
     */
    
    /*swaps for selection sort*/
    
    Integer[] swaps_for_intlist_sel={5,0,5,3};
    
    Integer[] swaps_for_strlist_sel={0,1,2,1,3};
    
    Integer[] swaps_for_dblist_sel= {5,0,4};
    
    
    /*swaps for insertion sort*/
    
    Integer[] swaps_for_intlist_ins={18,0,55,11};
    Integer[] swaps_for_strlist_ins={0,1,8,1,21};
    Integer[] swaps_for_dblist_ins=	{7,0,28};
    
    
    
    
    /**
     * Generic SelectionSorting and InsertionSorting Classes are to be created as your lab assignment
     **/
    
    SelectionSorting selectsort=new SelectionSorting();
	InsertionSorting insertsort=new InsertionSorting();
	
	
	/**
	 * Test case to test sorting of array of integers using selection sort
	 **/
	
	@Test
	public void selsort_intarray() 
    {
        for (int k = 0; k < intlist.length; k++)
		{
		
		/**
		 * Define a 'Sort(T[])' method in your SelectionSorting class
		 */
		intlist[k]=selectsort.Sort(intlist[k]);
		//selectsort.printArray(intlist[k]);
		//System.out.println();		
        for (int j = 0; j < intlist[k].length - 1; j++) {
            if (intlist[k][j] > intlist[k][j + 1]) {
              fail("Gives "+intlist[k][j] +" before "+ intlist[k][j + 1]+" in subarray "+k);
            }
          }
		}
    }
	
	
	/**
	 * Test case to test sorting of array of Doubles using selection sort
	 **/
	
	@Test
	public void selsort_doublearray() 
    {
        
		for (int k = 0; k < dblist.length; k++)
		{
			
		dblist[k]=selectsort.Sort(dblist[k]);
		//selectsort.printArray(dblist[k]);
        //System.out.println();		
        for (int j = 0; j < dblist[k].length - 1; j++) {
            if (dblist[k][j] > dblist[k][j + 1]) {
              fail("Gives "+dblist[k][j] +" before "+ dblist[k][j + 1]+" in subarray "+k);
            }
          }
		}
    }
	
	
	/**
	 * Test case to test sorting of array of Strings using selection sort
	 **/
	
	@Test
	public void selsort_strarray() 
    {     
		for (int k = 0; k < strlist.length; k++)
		{
		
		strlist[k]=selectsort.Sort(strlist[k]);
        //selectsort.printArray(strlist[k]);
        //System.out.println();
        for (int j = 0; j < strlist[k].length - 1; j++) {
            if (strlist[k][j].compareTo(strlist[k][j + 1])>0) {
              fail("Gives "+strlist[k][j] +" before "+ strlist[k][j + 1]+" in subarray "+k);
            }
          }
		}
    }
	
	
	/**
	 * Test case to test sorting of array of integers using insertion sort
	 **/
	
	@Test
	public void inssort_intarray() 
    {
        
		for (int k = 0; k < intlist.length; k++)
		{
		/**
		 * Define a 'Sort(T[])' method in your InsertionSorting class
		 */
		intlist[k]=insertsort.Sort(intlist[k]);
		//insertsort.printArray(intlist[k]);
		//System.out.println();		
        for (int j = 0; j < intlist[k].length - 1; j++) {
            if (intlist[k][j] > intlist[k][j + 1]) {
              fail("Gives "+intlist[k][j] +" before "+ intlist[k][j + 1]+" in subarray "+k);
            }
          }
		}
    }
	
	
	/**
	 * Test case to test sorting of array of doubles using insertion sort
	 **/
	
	@Test
	public void inssort_doublearray() 
    {
        
		for (int k = 0; k < dblist.length; k++)
		{
			
		dblist[k]=insertsort.Sort(dblist[k]);
		//insertsort.printArray(dblist[k]);
        //System.out.println();		
        for (int j = 0; j < dblist[k].length - 1; j++) {
            if (dblist[k][j] > dblist[k][j + 1]) {
              fail("Gives "+dblist[k][j] +" before "+ dblist[k][j + 1]+" in subarray "+k);
            }
          }
		}
    }
	
	/**
	 * Test case to test sorting of array of Strings using insertion sort
	 **/
	
	@Test
	public void inssort_strarray() 
    {     
		for (int k = 0; k < strlist.length; k++)
		{
        strlist[k]=insertsort.Sort(strlist[k]);
        //insertsort.printArray(strlist[k]);
        //System.out.println();
        for (int j = 0; j < strlist[k].length - 1; j++) {
            if (strlist[k][j].compareTo(strlist[k][j + 1])>0) {
              fail("Gives "+strlist[k][j] +" before "+ strlist[k][j + 1]+" in subarray "+k);
            }
          }
		}
    }
	
	
	/**
	 * Test cases to evaluate swaps of insertion sort,
	 * so your InsertionSorting class must have a
	 * swaps field that evaluates the swaps
	 * 
	 **/
	
	@Test
	public void inssort_str_swaps()
	{//For array of strings
		for (int k = 0; k < strlist.length; k++)
		{
        insertsort.Sort(strlist[k]);
		//assertEquals(insertsort.swaps,(int)swaps_for_strlist_ins[k]);
        System.out.println("str:"+insertsort.swaps);
		}
	}
	
	@Test
	public void inssort_int_swaps()
	{//For array of integers
		for (int k = 0; k < intlist.length; k++)
		{
        insertsort.Sort(intlist[k]);
        assertEquals(insertsort.swaps,(int)swaps_for_intlist_ins[k]);
        //System.out.println("int:"+insertsort.swaps);
		}
	}
	
	@Test
	public void inssort_double_swaps()
	{//For array of doubles
		for (int k = 0; k < dblist.length; k++)
		{
        insertsort.Sort(dblist[k]);
        assertEquals(insertsort.swaps,(int)swaps_for_dblist_ins[k]);
        //System.out.println("db:"+insertsort.swaps);
		}
	}
	
	
	/**
	 * Test cases to evaluate swaps of selection sort,
	 * so your SelectionSorting class must have a
	 * swaps field that evaluates the swaps
	 * 
	 **/
	
	@Test
	public void selsort_str_swaps()
	{//For array of strings
		for (int k = 0; k < strlist.length; k++)
		{
        selectsort.Sort(strlist[k]);
        assertEquals(selectsort.swaps,(int)swaps_for_strlist_sel[k]);
        //System.out.println(selectsort.swaps);
		}
	}

	@Test
	public void selsort_int_swaps()
	{//For array of integers
		for (int k = 0; k < intlist.length; k++)
		{
        selectsort.Sort(intlist[k]);
        assertEquals(selectsort.swaps,(int)swaps_for_intlist_sel[k]);
		//System.out.println("int:"+selectsort.swaps);
		}
	}
	
	@Test
	public void selsort_double_swaps()
	{//For array of doubles
		for (int k = 0; k < dblist.length; k++)
		{
        selectsort.Sort(dblist[k]);
        assertEquals(selectsort.swaps,(int)swaps_for_dblist_sel[k]);
        //System.out.println("db:"+selectsort.swaps);
		}
	}
	
	
}
