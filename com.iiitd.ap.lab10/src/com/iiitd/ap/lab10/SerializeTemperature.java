/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
package com.iiitd.ap.lab10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SerializeTemperature extends Observer {

	public SerializeTemperature(TemperatureSensor temperatureSensor) {
		// TODO Auto-generated constructor stub
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.attach(this);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println("serializer writes in file");
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("temperaturedata.txt", true)))) {
		    out.println(temperatureSensor.getTemperature()+","+temperatureSensor.getCity());
		    //more code
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
		
	}

}
