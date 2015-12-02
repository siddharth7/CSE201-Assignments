package com.iiitd.ap.lab1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * 
 * @author devika
 *
 */
public class BonusSortTest {

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


	    /**********************************************
		 * Bonus Question
		 * ********************************************
		 */
		
		/**Tests for Bonus Assignment
		 * 
		 */
		
		
		/**
		 * Create generic Sort class called Bonus_sort
		 * such that it does not exceed the swaps bounds as defined below
		 */
		Bonus_sort1<Integer> bs1=new Bonus_sort1<Integer>();
		Bonus_sort1<Double> bs2=new Bonus_sort1<Double>();
		Bonus_sort1<String> bs3=new Bonus_sort1<String>();

		
		Integer[] swaps_for_intlist_bonus={9,0,5,5};

		Integer[] swaps_for_strlist_bonus={0,1,2,1,3};

		Integer[] swaps_for_dblist_bonus={5,0,4};
		
		@Test
		public void bonussort_intarray() 
	    {
	        
			for (int k = 0; k < intlist.length; k++)
			{
			
			/**
			 * Define a 'Sort(T[])' method in your Bonus_Sort class
			 */
			intlist[k]=bs1.Sort(intlist[k]);
			//bs1.printArray(intlist[k]);
			//System.out.println();		
	        for (int j = 0; j < intlist[k].length - 1; j++) {
	            if (intlist[k][j] > intlist[k][j + 1]) {
	              fail("Gives "+intlist[k][j] +" before "+ intlist[k][j + 1]+" in subarray "+k);
	            }
	          }
			}
	    }

		
		@Test
		public void bonussort_doublearray() 
	    {
	        
			for (int k = 0; k < dblist.length; k++)
			{
			
			/**
			 * Define a 'Sort(T[])' method in your Bonus_Sort class
			 */
			dblist[k]=bs2.Sort(dblist[k]);
			//bs2.printArray(dblist[k]);
			//System.out.println();		
	        for (int j = 0; j < dblist[k].length - 1; j++) {
	            if (dblist[k][j] > dblist[k][j + 1]) {
	              fail("Gives "+dblist[k][j] +" before "+ dblist[k][j + 1]+" in subarray "+k);
	            }
	          }
			}
	    }
		
		@Test
		public void bonussort_strarray() 
	    {
	        
			for (int k = 0; k < strlist.length; k++)
			{
			
			/**
			 * Define a 'Sort(T[])' method in your Bonus_Sort class
			 */
			strlist[k]=bs3.Sort(strlist[k]);
			//bs3.printArray(strlist[k]);
			//System.out.println();		
	        for (int j = 0; j < strlist[k].length - 1; j++) {
	            if (strlist[k][j].compareTo(strlist[k][j + 1]) >0)  {
	              fail("Gives "+strlist[k][j] +" before "+ strlist[k][j + 1]+" in subarray "+k);
	            }
	          }
			}
	    }
		
		/**
		 * Test cases to evaluate swaps of bonus sort,
		 * so your Bonus_sort class must have a
		 * swaps field that evaluates the swaps
		 * i.e the number of steps taken in your sorting algorithms
		 **/
		
		
		@Test
		public void bsort_int_swaps()
		{//For array of integers
			for (int k = 0; k < intlist.length; k++)
			{
	        bs1.Sort(intlist[k]);
	        assertEquals(bs1.swaps,(int)swaps_for_intlist_bonus[k]);
			//System.out.println("int:"+bs1.swaps);
			}
		}
		
		@Test
		public void bsort_str_swaps()
		{//For array of strings
			for (int k = 0; k < strlist.length; k++)
			{
	        bs3.Sort(strlist[k]);
	       // System.out.println("str:"+bs3.swaps);
	        assertEquals(bs3.swaps,(int)swaps_for_strlist_bonus[k]);
	        
			}
		}

		@Test
		public void bsort_double_swaps()
		{//For array of doubles
			for (int k = 0; k < dblist.length; k++)
			{
	        bs2.Sort(dblist[k]);
	        assertEquals(bs2.swaps,(int)swaps_for_dblist_bonus[k]);
	       // System.out.println("db:"+bs2.swaps);
			}
		}
		
		

}
