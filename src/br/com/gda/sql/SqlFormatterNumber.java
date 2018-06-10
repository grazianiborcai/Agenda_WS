package br.com.gda.sql;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
	
	
	
	public static Date localToSqlDate(LocalDate localDate) {
		Date resultDate = null;
		
		if (localDate != null) 
			resultDate = Date.valueOf(localDate);		
		
		return resultDate;
	}
	
	
	
	public static String dateToString(LocalDate localDate) {		
		if (localDate == null)
			return null;
		
		return localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
	}
	
	
	
	public static String timeToString(LocalTime localTime) {	
		if (localTime == null)
			return null;
		
		return localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
	}
}
