/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
//package com.iiitd.ap.lab10;
//
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
//public class threadtest2 {
//	public static void runtest()
//	{
//		final int number_of_threads = 3;
//		ExecutorService executor = Executors.newFixedThreadPool(number_of_threads);
//		String[] hostList = { "Delhi", "Bombay", "Bangalore" };
// 
//		for (int i = 0; i < hostList.length; i++) {
// 
//			String location = hostList[i];
//			Runnable worker = new MyRunnable(location);
//			executor.execute(worker);
//		}
//		executor.shutdown();
//		while (!executor.isTerminated()) {
// 
//		}
//		System.out.println("\nFinished all threads");
//	}
// 
//	public static class MyRunnable implements Runnable {
//		private final String location;
// 
//		MyRunnable(String location) {
//			this.location = location;
//		}
// 
//		@Override
//		public void run() {
// 
//			System.out.println(location);
//			TemperatureLog temper=  new TemperatureLog(location, 23);
//			System.out.println(TemperatureLog.logs);
//			
//		}
//	}
//	public static void main(String[] args) {
//		  // run in a second
//		  final long timeInterval = 5000;
//		  Runnable runnable = new Runnable() {
//		  
//		  public void run() {
//		    while (true) {
//		      // ------- code for task to run
//		    	Date d = new Date();
//		        System.out.println(d.toString());
//		        System.out.println(Thread.currentThread().getName()+" Start");
//		      System.out.println("Hello !!");
//		        System.out.println(Thread.currentThread().getName()+" End.");
//		        Date d2 = new Date();
//		        System.out.println(d2.toString());
//		      runtest();
//		      // ------- ends here
//		      try {
//		       Thread.sleep(timeInterval);
//		      } catch (InterruptedException e) {
//		        e.printStackTrace();
//		      }
//		      }
//		    }
//		  };
//		  
//		  Thread thread = new Thread(runnable);
//		  thread.start();
//		  }
//}
