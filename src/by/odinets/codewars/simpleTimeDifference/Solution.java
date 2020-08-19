package by.odinets.codewars.simpleTimeDifference;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	public static String solve(String [] arr){
		Set<Integer> allInterval = new TreeSet<Integer>();
		allInterval = convertToMinute(arr);
		int maxInterval = searchMaxInterval(allInterval);
		String maxIntervalStr = convertToHourMinute(maxInterval);
		return maxIntervalStr;
	}
	
	public static Set<Integer> convertToMinute(String[] arr) {
		Set<Integer> allInterval = new TreeSet<Integer>();
		for(String elem : arr) {
			String hours = "";
			String min = "";
			if(elem.contains(":")) {
				hours = elem.split(":")[0];
				min = elem.split(":")[1];
			}
			if(elem.contains(".")) {
				hours = elem.split("\\.")[0];
				min = elem.split("\\.")[1];
			}
			int hoursInt = Integer.parseInt(hours);
			int minInt = Integer.parseInt(min);
			int hoursToMin = hoursInt*60;
			int minAll = hoursToMin + minInt;
			allInterval.add(minAll);
		}
		System.out.println("allInterval :: " + allInterval);
		return allInterval;
	}
	
	public static Integer searchMaxInterval(Set<Integer> allInterval) {
		int maxInterval = 0;
		int firstElement = allInterval.iterator().next();
		for(Integer elem : allInterval) {
			int interval = elem - firstElement;
			if(interval >= maxInterval) {
				maxInterval = interval;
			}
			firstElement = elem;
		}
		if(maxInterval == 0) {
			maxInterval = 24 * 60;
		}
		maxInterval = maxInterval - 1;
		return maxInterval;
	}
	
	public static String convertToHourMinute(Integer maxInterval) {
		int hours = maxInterval / 60;
		int minute = maxInterval % 60;
		String hoursStr = String.valueOf(hours);
		String minuteStr = String.valueOf(minute);
		if(hoursStr.length() < 2) {
			hoursStr = "0" + hoursStr;
		}
		if(minuteStr.length() < 2) {
			minuteStr = "0" + minuteStr;
		}
		String hourMinute = hoursStr + ":" + minuteStr;
		return hourMinute;
	}
}
