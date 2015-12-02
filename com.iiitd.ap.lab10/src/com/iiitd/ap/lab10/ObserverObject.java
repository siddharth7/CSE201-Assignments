/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
package com.iiitd.ap.lab10;

public class ObserverObject extends Observer{

	String name;
	public ObserverObject(String name, TemperatureSensor temperatureSensor)
	{
		this.name=name;
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.attach(this);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println(this.name +" found out temperature is " + temperatureSensor.getTemperature()+temperatureSensor.getCity());
	}
	
}
