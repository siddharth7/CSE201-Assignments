/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TemperatureSensor {

	private List<Observer> observers = new ArrayList<Observer>();
	   private int temperature;
	   private String city;
	  static HashMap<String, ArrayList<Integer>> alldata= new HashMap<String, ArrayList<Integer>>();
	public synchronized void setnewdata(int temp, String area)
	{
		this.temperature=temp;
		this.city=area;
		alldata.get(area).add(temp);
//		System.out.println("--------------------------");
//		System.out.println(alldata); 
//		System.out.println("--------------------------");
		notifyAllObservers();
	}
	   public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyAllObservers();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update();
	      }
	   }
}
