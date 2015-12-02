/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
package com.iiitd.ap.lab10;

import java.util.ArrayList;

public class TemperaturePredictor2 extends Observer {

	public TemperaturePredictor2(TemperatureSensor temperatureSensor)
	{
	this.temperatureSensor=temperatureSensor;
	this.temperatureSensor.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println("predictor2 got the temperature value"+ temperatureSensor.getTemperature()+" "+temperatureSensor.getCity());
		ArrayList<Integer> statis=TemperatureSensor.alldata.get(temperatureSensor.getCity());
		System.out.println("Temperature according to Predictor2"+" of "+temperatureSensor.getCity()+" is "+statis.get(statis.size()/2));
	}
	
	
}
