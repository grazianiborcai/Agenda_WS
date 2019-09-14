package br.com.gda.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.gda.common.DefaultValue;
import br.com.gda.message.sysLog.Syslog;

public abstract class InfoRecord extends Syslog implements Cloneable {
	public String codLanguage;
	
	
	protected InfoRecord(Class<? extends InfoRecord> childClazz) {
		super(childClazz);
		
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
			super.logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isTimeEqual(LocalTime timeOne, LocalTime timeTwo) {
		try {
			if (timeOne == null && timeTwo == null)
				return true;
			
			return timeOne.equals(timeTwo);
			
		} catch (Exception e) {
			super.logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isStringEqual(String stringOne, String stringTwo) {
		try {
			if (stringOne == null && stringTwo == null)
				return true;
			
			return stringOne.equals(stringTwo);
			
		} catch (Exception e) {
			super.logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isRecordEqual(InfoRecord recordOne, InfoRecord recordTwo) {
		try {
			if (recordOne == null && recordTwo == null)
				return true;
			
			return recordOne.equals(recordTwo);
			
		} catch (Exception e) {
			super.logException(e);
			return false;
		}
	}
	
	
	
	protected boolean isListEqual(List<? extends InfoRecord> listOne, List<? extends InfoRecord> listTwo) {
		try {
			if (listOne == null && listTwo == null)
				return true;
			
			return listOne.equals(listTwo);
			
		} catch (Exception e) {
			super.logException(e);
			return false;
		}
	}
}
