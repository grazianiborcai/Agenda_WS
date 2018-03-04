package br.com.gda.sql;

import java.sql.Time;
import java.time.LocalTime;

public final class SqlFormatterNumber {
	public static String numberToString(long number) {
		if (number < 0)
			return null;
		
		return Long.toString(number);
	}
	
	
	
	public static String numberToString(int number) {
		if (number < 0)
			return null;
		
		return Integer.toString(number);
	}
	
	
	
	public static Time localToSqlTime(LocalTime localTime) {
		Time resultTime = null;
		
		if (localTime != null) 
			resultTime = Time.valueOf(localTime);		
		
		return resultTime;
	}
}
