package com.iiitd.ap.lab4;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class Test_DBLP {

		DBLP dblp;
		private String author1;
		private String author2;
		private ArrayList<String> expected_result;

		public Test_DBLP(String author1, String author2,ArrayList<String> expected_result) {
	    	this.author1=author1;
	    	this.author2=author2;
	    	this.expected_result=expected_result;
	    }

	    @Before
	    public void initialize() {
	    	dblp=new DBLP();

	    }

		@Parameterized.Parameters
	    public static Collection<Object[]> test1() {
			 //[Number of Test Cases][Number of Parameters]
			 Object[][] o = new Object[6][3];

			 //Test Case 1
			 //Set Authors
			 o[0][0]="Karin Greimel";
			 o[0][1]="Barbara Jobstmann";

			 //Set Expected Result
			 ArrayList<String> expected_result1 = new ArrayList<String>();
			 expected_result1.add("Synthesizing robust systems.");
			 expected_result1.add("Multi-tilde-bar expressions and their automata.");
			 o[0][2]=expected_result1;

			 //Test Case 2
			 //Set Authors
			 o[1][0]="Maurice Bruynooghe";
			 o[1][1]="Jan Ramon";

			 //Set Expected Result
			 ArrayList<String> expected_result2 = new ArrayList<String>();
			 expected_result2.add("A polynomial time computable metric between point sets.");
			 o[1][2]=expected_result2;

			 //Test Case 3
			 //Set Authors
			 o[2][0]="Klaus Kspert";
			 o[2][1]="Barbara Jobstmann";

			 //Set Expected Result
			 ArrayList<String> expected_result3 = new ArrayList<String>();
			 o[2][2]=expected_result3;

			 //Test Case 4
			 //Set Authors
			 o[3][0]="Arto Salomaa";
			 o[3][1]="Grzegorz Rozenberg";

			 //Set Expected Result
			 ArrayList<String> expected_result4 = new ArrayList<String>();
			 expected_result4.add("Nonterminals Homomorphisms and Codings in Different Variations of OL-Systems.  I. Deterministic Systems.");
			 o[3][2]=expected_result4;

			 //Test Case 5
			 //Set Authors
			 o[4][0]="Ivana Cern";
			 o[4][1]="Davide Sangiorgi";

			 //Set Expected Result
			 ArrayList<String> expected_result5 = new ArrayList<String>();
			 o[4][2]=expected_result5;

			 //Test Case 6
			 //Set Authors
			 o[5][0]="Moon-Jung Chung";
			 o[5][1]="Michael Evangelist";

			 //Set Expected Result
			 ArrayList<String> expected_result6 = new ArrayList<String>();
			 expected_result6.add("Complete Problems for Space Bounded Subclasses of NP.");
			 o[5][2]=expected_result6;

			 //Return
			 return Arrays.asList(o);
	    }


		// This Test will run 6 times for each of the above specified parameters.
		@Test
		public void check_result()
		{
			ArrayList<String> result=dblp.coauthored(author1, author2);
			System.out.println("###########");
			System.out.println("Author 1: "+author1);
			System.out.println("Author 2: "+author2);
			System.out.println("-----------");
			System.out.println("Your Result:");
			System.out.println(result.toString());
			System.out.println("-----------");
			System.out.println("Our Result");
			System.out.println(expected_result.toString());
			System.out.println("-----------");
			assertArrayEquals(result.toArray(),expected_result.toArray());
		}
	}



