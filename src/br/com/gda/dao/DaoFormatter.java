package br.com.gda.dao;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class DaoFormatter {
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
	
	
	
	public static Timestamp localToSqlTimestamp(LocalDateTime localDateTime) {
		Timestamp resultDate = null;
		
		if (localDateTime != null) 
			resultDate = Timestamp.valueOf(localDateTime);		
		
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
	
	
	
	public static String charToString(char c) {	
		if (c == Character.MIN_VALUE)
			return null;
		
		return Character.toString(c);
	}
	
	
	
	public static String dateTimeToString(LocalDateTime localDateTime) {	
		if (localDateTime == null)
			return null;
		
		return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
	
	
	
	public static Integer boxNumber(int number) {
		if (number < 0)
			return null;
		
		return number;
	}
	
	
	
	public static Long boxNumber(long number) {
		if (number < 0)
			return null;
		
		return number;
	}
	
	
	public static Float boxNumber(float number) {
		if (number < 0)
			return null;
		
		return number;
	}
	
	
	
	public static float longToDecimal(long number) {
		float result = number;
		result = result / 100;
		return result;
	}
	
	
	
	public static long decimalToLong(float number) {
		float result = number * 100;
		return (long) result;
	}
	
	
	
	public static String booleanToString(boolean boole) {
		if (boole == false)
			return "0";
		
		return "1";
	}
}
