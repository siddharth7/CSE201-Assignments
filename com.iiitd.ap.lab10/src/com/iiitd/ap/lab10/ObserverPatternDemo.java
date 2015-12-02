/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ObserverPatternDemo {
	static TemperatureSensor temperatureSensor;
	static int ot=3;
	public static synchronized int generate(){
		long millis = System.currentTimeMillis() % 1000;
		millis *= ot;
		millis += ot;
		int i = (int)millis % 21;
		i += 25;
		ot += 2;
		return i;
	}
	public static void runtest()
	{
		final int number_of_threads = 3;
		ExecutorService executor = Executors.newFixedThreadPool(number_of_threads);
		String[] hostList = { "Delhi", "Bombay", "Bangalore" };
 
		for (int i = 0; i < hostList.length; i++) {
 
			String location = hostList[i];
			Runnable worker = new MyRunnable(location);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
	}
	public static class MyRunnable implements Runnable {
		private final String location;
 
		MyRunnable(String location) {
			this.location = location;
		}
 
		@Override
		public void run() {
 
			//System.out.println(location);
//			TemperatureLog temper=  new TemperatureLog(location, 23);
//			System.out.println(TemperatureLog.logs);
			//Random rand = null;
			//int randomNum = rand.nextInt((40 - 20) + 1) + 20;
			//int randomNum=ThreadLocalRandom.current().nextInt(25, 40 + 1);
			int randomNum=generate();
			System.out.println(location+ " " + randomNum);
			temperatureSensor.setnewdata(randomNum, location);
			
		}
	}
	public static void main(String[] args) {
	      temperatureSensor = new TemperatureSensor();
	      ArrayList<Integer> temp= new ArrayList<>();
	      temp.add(35);
	      ArrayList<Integer> temp1= new ArrayList<>();
	      temp1.add(35);
	      ArrayList<Integer> temp2= new ArrayList<>();
	      temp2.add(35);
	      TemperatureSensor.alldata.put("Delhi",temp);
	      TemperatureSensor.alldata.put("Bombay",temp1);
	      TemperatureSensor.alldata.put("Bangalore",temp2);
	      
	      new SerializeTemperature(temperatureSensor);
	      new TemperaturePredictor1(temperatureSensor);
	      new TemperaturePredictor2(temperatureSensor);
	      new GenerateStats(temperatureSensor);
	      new ObserverObject("BBC",temperatureSensor);
	      new ObserverObject("WeatherLog",temperatureSensor);
	      new ObserverObject("Yahooweather",temperatureSensor);
	      new ObserverObject("GoogleWeatherStats",temperatureSensor);
//	      for(int i =0;i<5;i++)
//	    	  {
//	    	  System.out.println("First state change: 15");
//		      temperatureSensor.setnewdata(15, "Delhi");
//		      System.out.println("Second state change: 10");
//		      temperatureSensor.setnewdata(10, "Bombay");
//		      System.out.println("Third state change: 5");
//		      temperatureSensor.setnewdata(5, "Bangalore");
//		      System.out.println(TemperatureSensor.alldata);
//		      
	    	  
	      final long timeInterval = 5000;
		  Runnable runnable = new Runnable() {
		  
		  public void run() {
		    while (true) {
		      // ------- code for task to run
		    	Date d = new Date();
		        System.out.println(d.toString());
		        System.out.println(Thread.currentThread().getName()+" Start");
		      System.out.println("Hello !!");
		        System.out.println(Thread.currentThread().getName()+" End.");
		        Date d2 = new Date();
		        System.out.println(d2.toString());
		      runtest();
		      // ------- ends here
		      try {
		       Thread.sleep(timeInterval);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		      }
		    }
		  };
		  
		  Thread thread = new Thread(runnable);
		  thread.start();
	}
}
