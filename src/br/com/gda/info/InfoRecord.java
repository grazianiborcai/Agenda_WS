package br.com.gda.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public abstract class InfoRecord implements Cloneable {
	
	protected static <T> List<T> copyFrom(List<?> sourceObjs, Class<T> targetClass) {
		if (sourceObjs == null)
			return null;
		
		List<T> resultObjs = new ArrayList<>();
		
		for (Object eachObj : sourceObjs) {
			resultObjs.add(copyFrom(eachObj, targetClass));
		}
		
		return resultObjs;
	}
	
	
	
	protected static <T> T copyFrom(Object sourceObj, Class<T> targetClass) {
		Gson gson = new Gson();
		String sourceStr = gson.toJson(sourceObj);		
		return gson.fromJson(sourceStr, targetClass);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	protected boolean isDateEqual(LocalDate dateOne, LocalDate dateTwo) {
		try {
			if (dateOne == null && dateTwo == null)
				return true;
			
			return dateOne.isEqual(dateTwo);
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	protected boolean isTimeEqual(LocalTime timeOne, LocalTime timeTwo) {
		try {
			if (timeOne == null && timeTwo == null)
				return true;
			
			return timeOne.equals(timeTwo);
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	protected boolean isStringEqual(String stringOne, String stringTwo) {
		try {
			if (stringOne == null && stringTwo == null)
				return true;
			
			return stringOne.equals(stringTwo);
			
		} catch (Exception e) {
			return false;
		}
	}
}
