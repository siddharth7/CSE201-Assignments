package com.iiitd.ap.lab6;
/**
 * Siddharth Singh
 * 2014105
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
public class paper {
	public static List<Entry<String, Integer>> sort_map(TreeMap<String, Integer> map) {
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
				int value = (o2.getValue()).compareTo( o1.getValue() );
				if(value != 0) return value;
				else {
					return (o1.getKey()).compareTo(o2.getKey());
				}
			}
		});
		//System.out.println(set);
		//System.out.println(list);
//		TreeMap<String, Integer> map2=new  TreeMap<String, Integer>();
//		for(Map.Entry<String, Integer> entry : list) {
//            map2.put(entry.getKey(), entry.getValue());
//		}
//		System.out.println(map2);
		return list;
	}
	static TreeMap<String, Integer> readfromfile(String filename, ArrayList<String> stopw)
	{
        TreeMap<String , Integer> innerdata= new TreeMap<String, Integer>();
		BufferedReader buffr = null;
    	String line;
    	int i =0;
    	try {
    		
    		buffr = new BufferedReader(new FileReader("./src/Papers/"+filename));
    		while ((line = buffr.readLine()) != null) 
    		{
    			String[] data = line.split(" ");
    			i++;
    				if(i==6)
    				{
    					//System.out.println(data[0]);
    					try{
    						//System.out.println(data[1]);
    						for(int count=0; count < data.length;count++)
    						{
    							String w=(data[count].replaceAll("[-+.^:,()]","")).toLowerCase();
    							if(innerdata.containsKey((data[count].replaceAll("[-+.^:,()]","")).toLowerCase()))
	    						{
    								//System.out.println(w);
	    							if(stopw.contains(w))
	    							{
//	    								int num=innerdata.get((data[count].replaceAll("[-+.^:,()]","")).toLowerCase());
//	    								innerdata.put((data[count].replaceAll("[-+.^:,()]","")).toLowerCase(),num+1);
    								//System.out.println(data[count].replaceAll("[-+.^:,()]",""));
	    								
	    							}
	    							else
	    							{
	    								int num=innerdata.get((data[count].replaceAll("[-+.^:,()]","")).toLowerCase());
	    								innerdata.put((data[count].replaceAll("[-+.^:,()]","")).toLowerCase(),num+1);
	    								//System.out.println(data[count].replaceAll("[-+.^:,()]","")+(num+1));
	    							}
	    						}
	    						else
	    						{
	    							if(stopw.contains(w))
	    							{
//	    								innerdata.put((data[count].replaceAll("[-+.^:,()]","")).toLowerCase(), 1);
	    								//System.out.println(data[count].replaceAll("[-+.^:,()]",""));
	    							}
	    							else
	    							{
	    								innerdata.put((data[count].replaceAll("[-+.^:,()]","")).toLowerCase(), 1);
	    								//System.out.println(data[count].replaceAll("[-+.^:,()]",""));
	    							}
	    						}
    						}
    					}
    					catch(Exception e){
	
    					}
    				}
    			
    		}
    	}
    	catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	//System.out.println(innerdata);
		return innerdata;
	}
	static boolean is_title(String listOfFiles1, String title)
	{
		BufferedReader buffr = null;
    	String line;
    	try {
    		
    		buffr = new BufferedReader(new FileReader(listOfFiles1));
    		while ((line = buffr.readLine()) != null) 
    		{
    			String[] data = line.split(" ");
    			
    				
    				{
    					//System.out.println(data[0]);
    					try{
    						if(title.equals(line))
    						{
    							return true;
    						}
    						else
    						{
    							return false;
    						}
    							
    						
    					}
    					catch(Exception e){
	
    					}
    				}
    			
    		}
    	}
    	catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		return false;
	}
	static boolean is_author(String listOfFiles1, String author)
	{
		BufferedReader buffr = null;
    	String line;
    	int i=0;
    	try {
    		buffr = new BufferedReader(new FileReader(listOfFiles1));
    		while ((line = buffr.readLine()) != null) 
    		{
    			String[] data = line.split(", ");
    			i++;
    			//System.out.println(data.length);
    				if(i==3)
    				{
    					//System.out.println(data[0]);
    					try{
    						for(int j=0;j<data.length;j++)
    						{
	    						//System.out.println(data[j]);
//	    						String auth=data[j];
//	    						char first=auth.charAt(0);
//	    						if(first==" ")
//	    						{
//	    							
//	    						}
    							if(author.equals(data[j]))
	    						{
	    							return true;
	    						}
	    						
    						}
    							
    						
    					}
    					catch(Exception e){
	
    					}
    				}
    			
    		}
    	}
    	catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		return false;
	}
	static ArrayList<String> stoppie()
	{
		BufferedReader buffr = null;
    	String line;
    	ArrayList<String> words = new ArrayList<>();
    	int i=0;
    	try {
    		buffr = new BufferedReader(new FileReader("./src/stopwords.txt"));
    		while ((line = buffr.readLine()) != null) 
    		{
    			String[] data = line.split(", ");
    					try
    					{
    					words.add(data[0]);		
    						
    					}
    					catch(Exception e){
	
    					}
    		}
    	}
    	catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		return words;
	}
	
	public static void main(String args[])
	{
		Scanner inp= new Scanner(System.in);
		TreeMap<String, TreeMap<String, Integer>> filedata = new TreeMap<String, TreeMap<String, Integer>>();
		File folder = new File("./src/Papers");
		 //ArrayList<String> stopw=stoppie();
		 ArrayList<String> stopw=new ArrayList<String>();
		    //System.out.println(stopw);
		stopw.addAll(Arrays.asList("a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the"));


		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) 
		      {
		    	  TreeMap<String, Integer> map=readfromfile(listOfFiles[i].getName(),stopw);
		    	  //List<Entry<String , Integer>> sorted =sort_map(map);
		    	  
		    	  
		    	  //System.out.println(sorted);
		    	  //System.out.println(i);
		    	  
		        filedata.put(listOfFiles[i].getName(), map);
		        //TreeMap map = new TreeMap();
		     
		      }
		     
//		      System.out.println(".......................");
//		      System.out.println(".......................");
//		      System.out.println(".......................");
//		      System.out.println(".......................");
//		      System.out.println(i);
		      
		    }
		   //System.out.println(filedata);
		while(true)
		{
			int topk=inp.nextInt();
			int k= inp.nextInt();
			if(k==0)
			{
				System.exit(0);
			}
			else if(k==1)
			{
				
//				System.out.println(k);
				System.out.println("Input Title");
				Scanner inp2= new Scanner(System.in);
				String input_title;
				input_title=inp2.nextLine();
				//System.out.println(input_title);
				
				File folder1 = new File("./src/Papers");
				File[] listOfFiles1 = folder1.listFiles();
				int flag=0;
				    for (int i = 0; i < listOfFiles1.length; i++) {
				      if (listOfFiles1[i].isFile()) 
				      {
				        if(is_title(listOfFiles1[i].toString(),input_title))
				        		{
				        			flag=1;
				        			//System.out.println("Title found");
				        			//System.out.println(listOfFiles1[i].getName().toString());
				        			TreeMap<String, Integer> quer=filedata.get(listOfFiles1[i].getName().toString());
				        			List<Entry<String , Integer>> sorted =sort_map(quer);
				        			//System.out.println(quer);
				        			
				        			int k2=0;
				        			for(int kk=0;kk<sorted.size();kk++) {
				        				  
				        				if(k2<topk)
					        				{
					        					//String key = entry.getKey();
					        					//Integer value = entry.getValue();
					        					System.out.println(sorted.get(kk).getKey()+" : "+sorted.get(kk).getValue());
					        					k2++;
					        				}
				        				else
				        				{
				        					break;
				        				}
				        				  
				        				}
				        		}
				        
				      }
				    }
				    if(flag==0)
				    {
				    	System.out.println("No such document");
				    }

			}
			else if(k==2)
			{
				//System.out.println(k);
				System.out.println("Enter Author");
				Scanner inp3= new Scanner(System.in);
				String input_author;
				input_author=inp3.nextLine();
				//System.out.println(input_author);
				File folder2 = new File("./src/Papers");
				TreeMap<String, Integer> fildata= new TreeMap<String, Integer>();
				File[] listOfFiles2 = folder2.listFiles();
				int flag=0;
				    for (int i = 0; i < listOfFiles2.length; i++) {
				      if (listOfFiles2[i].isFile()) 
				      {
				        if(is_author(listOfFiles2[i].toString(),input_author))
				        		{
				        			flag=1;
				        			//System.out.println(listOfFiles2[i].toString());
				        			TreeMap<String, Integer> quer=filedata.get(listOfFiles2[i].getName().toString());
				        			List<Entry<String , Integer>> sorted =sort_map(quer);
				        			//System.out.println(quer);
				        			int k2=0;
				        			for(int kk=0;kk<sorted.size();kk++) {
				        				  
				        				if(k2<topk)
					        				{
//					        					String key = entry.getKey();
//					        					Integer value = entry.getValue();
					        					//System.out.println(sorted.get(kk).getKey());
				        						//fildata.put(sorted.get(kk).getKey(), sorted.get(kk).getValue());
				        						if(fildata.containsKey(sorted.get(kk).getKey()))
					        					{
					        						int num=fildata.get((sorted.get(kk).getKey().replaceAll("[-+.^:,()]","")).toLowerCase());
					        						fildata.put(sorted.get(kk).getKey(), sorted.get(kk).getValue()+num);
					        					}
					        					else{
					        						fildata.put(sorted.get(kk).getKey(), sorted.get(kk).getValue());
					        					}
					        					k2++;
//					        					System.out.println(k2);
					        				}
				        				else
				        				{
				        					break;
				        				}
				        			}
				        		}
				        
				      }
				      //break;
				    }
				    if(flag==0)
				    {
				    	System.out.println("No such document");
				    }
			    if(flag==1)
			    {
			    	List<Entry<String , Integer>> sorted2 =sort_map(fildata);
			    	for(int kkk=0;kkk<topk;kkk++)
			    	{
			    		System.out.println(sorted2.get(kkk).getKey()+" : "+sorted2.get(kkk).getValue());
			    	}
				}

			}
			else if(k==3)
			{
				//System.out.println(k);
				TreeMap<String, Integer> filterdata=new TreeMap<String, Integer>();
				//System.out.println(input_author);
				File folder2 = new File("./src/Papers");
				File[] listOfFiles2 = folder2.listFiles();
			
				    for (int i = 0; i < listOfFiles2.length; i++) {
				      if (listOfFiles2[i].isFile()) 
				      {
				        
				        			//System.out.println(listOfFiles2[i].toString());
				        			TreeMap<String, Integer> quer=filedata.get((listOfFiles2[i].getName()).toString());
				        			//System.out.println(quer);
				        		
				        			for(Map.Entry<String,Integer> entry : quer.entrySet()) {
				        				  
				        				
					        					String key = entry.getKey();
					        					Integer value = entry.getValue();
					        					if(filterdata.containsKey(key))
					        					{
					        						int num=filterdata.get((key.replaceAll("[-+.^:,()]","")).toLowerCase());
					        						filterdata.put(key, value+num);
					        					}
					        					else{
					        						filterdata.put(entry.getKey(), entry.getValue());
					        					}
				        			}
					        				
		
				        }
				        		
				       
				      
				      //break;
				    }
				    //System.out.println(filterdata);
				    List<Entry<String, Integer>> sorted =sort_map(filterdata);
				    int k2=0;
        			for(int kk=0;kk<sorted.size();kk++) {
        				  
        				if(k2<topk)
	        				{
	        					//String key = entry.getKey();
	        					//Integer value = entry.getValue();
	        					System.out.println(sorted.get(kk).getKey()+" : "+sorted.get(kk).getValue());
	        					k2++;
	        				}
        				else
        				{
        					break;

        				}
        			}

			}
		}
		
	}
}

