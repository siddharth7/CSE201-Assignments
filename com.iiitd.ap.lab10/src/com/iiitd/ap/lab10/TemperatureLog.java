/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/
//package com.iiitd.ap.lab10;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class TemperatureLog {
//
//	public static HashMap<String, ArrayList<Integer>> logs;
//	public TemperatureLog(String state, int temperature) {
//		// TODO Auto-generated constructor stub
//		if(TemperatureLog.logs==null)
//			TemperatureLog.logs= new HashMap<String, ArrayList<Integer>>();
//		if(TemperatureLog.logs.containsKey(state))
//		{
//			List<Integer> itemsList = TemperatureLog.logs.get(state);
//			if(itemsList == null) {
//		         itemsList = new ArrayList<Integer>();
//		         itemsList.add(temperature);
//		         TemperatureLog.logs.put(state, (ArrayList<Integer>) itemsList);
//		    }
//			else
//			{
//				TemperatureLog.logs.get(state).add(temperature);
//			}
//		}
//		else
//		{
//			ArrayList<Integer> temp= new ArrayList<Integer>();
//			temp.add(temperature);
//			TemperatureLog.logs.put(state, temp);
//		}
//		
//	}
//	public static HashMap<String, ArrayList<Integer>> getLogs() {
//		return logs;
//	}
//	public static void setLogs(HashMap<String, ArrayList<Integer>> logs) {
//		TemperatureLog.logs = logs;
//	}
//}
