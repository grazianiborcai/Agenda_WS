package br.com.mind5.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
//import java.lang.reflect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public abstract class InfoRecord implements Cloneable {
	public String codLanguage;
	
	
	protected InfoRecord() {
		codLanguage = DefaultValue.language();
	}
	
	
	
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
		Gson gson = new GsonBuilder().serializeNulls().create();		
		
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
			logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isTimeEqual(LocalTime timeOne, LocalTime timeTwo) {
		try {
			if (timeOne == null && timeTwo == null)
				return true;
			
			return timeOne.equals(timeTwo);
			
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isStringEqual(String stringOne, String stringTwo) {
		try {
			if (stringOne == null && stringTwo == null)
				return true;
			
			return stringOne.equals(stringTwo);
			
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isRecordEqual(InfoRecord recordOne, InfoRecord recordTwo) {
		try {
			if (recordOne == null && recordTwo == null)
				return true;
			
			return recordOne.equals(recordTwo);
			
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isListEqual(List<? extends InfoRecord> listOne, List<? extends InfoRecord> listTwo) {
		try {
			if (listOne == null && listTwo == null)
				return true;
			
			return listOne.equals(listTwo);
			
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isListDateEqual(List<LocalDate> listOne, List<LocalDate> listTwo) {
		try {
			if (listOne == null && listTwo == null)
				return true;
			
			return listOne.equals(listTwo);
			
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}
	
	
	
	protected void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
	
	
	
	protected void checkCompareToArgument(InfoRecord arg0) {
		if (arg0 == null) {
			logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}
	}
}
