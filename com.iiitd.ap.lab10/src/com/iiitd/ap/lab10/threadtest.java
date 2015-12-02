/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
//package com.iiitd.ap.lab10;
//
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
// 
///**
// * @author Crunchify.com
// * 
// */
// 
//public class threadtest  {
//	private static final int number_of_threads = 3;
// 
//	public static void main(String args[]) throws Exception {
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
//		}
//	}
//}