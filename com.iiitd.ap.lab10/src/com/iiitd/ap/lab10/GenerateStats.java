/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.Collections;

public class GenerateStats extends Observer {

	public GenerateStats(TemperatureSensor temperatureSensor)
	{
	this.temperatureSensor=temperatureSensor;
	this.temperatureSensor.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println("GenerateStats got the temperature value"+ temperatureSensor.getTemperature() + temperatureSensor.getCity());
		ArrayList<Integer> statdata=TemperatureSensor.alldata.get(temperatureSensor.getCity());
		Collections.sort(statdata);
		//System.out.println(statdata);
		System.out.println("Min temperature is "+" of "+temperatureSensor.getCity()+" is "+statdata.get(0));
		System.out.println("Max temperature is "+" of "+temperatureSensor.getCity()+" is "+statdata.get(statdata.size()-1));
		if(statdata.size()%2==0)
		{
			System.out.println("Median Temperature"+" of "+temperatureSensor.getCity()+" is "+(float)(statdata.get((statdata.size()-1)/2)+statdata.get(statdata.size()/2))/2);
		}
		else
			System.out.println("Median Temperature"+" of "+temperatureSensor.getCity()+" is "+(float)statdata.get(statdata.size()/2));
		Float su=(float) 0;
		for(int i=0;i<statdata.size();i++)
		{
			su+=statdata.get(i);
		}
		System.out.println("Mean Temperature of "+" of "+temperatureSensor.getCity()+" is "+su/statdata.size());
	}
}
