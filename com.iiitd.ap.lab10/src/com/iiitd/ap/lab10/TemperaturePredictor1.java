/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
package com.iiitd.ap.lab10;

import java.util.ArrayList;

public class TemperaturePredictor1 extends Observer {

	public TemperaturePredictor1(TemperatureSensor temperatureSensor)
	{
	this.temperatureSensor=temperatureSensor;
	this.temperatureSensor.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println("predictor1 got the temperature value"+ temperatureSensor.getTemperature()+" "+temperatureSensor.getCity());
		ArrayList<Integer> statis=TemperatureSensor.alldata.get(temperatureSensor.getCity());
		int su=0;
		for(int i=0;i<statis.size();i++)
		{
			su+=statis.get(i);
		}
		System.out.println("Temperature according to Predictor1"+" of "+temperatureSensor.getCity()+" is "+su/statis.size());
	}
	
	
}
