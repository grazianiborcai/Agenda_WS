package br.com.gda.model;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public abstract class ModelRequestChecker {
	private String fieldName;
	private String headerParamValue;
	
	
	public ModelRequestChecker(HttpServletRequest request, String paramName, String objFieldName) {
		checkArgument(request, paramName, objFieldName);
		headerParamValue = parseParamValue(request, paramName);
		fieldName = objFieldName;
	}
	
	
	
	private void checkArgument(HttpServletRequest request, String paramName, String objFieldName) {
		if (request == null) {
			logException(new NullPointerException("request" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("request" + SystemMessage.NULL_ARGUMENT);
		}		
		
		
		if (paramName == null) {
			logException(new NullPointerException("paramName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("paramName" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
		if (objFieldName == null) {
			logException(new NullPointerException("objFieldName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("objFieldName" + SystemMessage.NULL_ARGUMENT);
		}	
	}
	
	
	
	private String parseParamValue(HttpServletRequest request, String paramName) {
		String result = request.getHeader(paramName);
		return result;
	}
	
	
	
	public boolean isValid(List<?> recordInfos) {
		checkArgument(recordInfos);
		
		if (shouldValidade(recordInfos, headerParamValue) == false)
			return true;
		
		
		for (Object eachRecord : recordInfos) {
			if (isValid(eachRecord, fieldName, headerParamValue) == false)
				return false;
		}
		
		
		return true;
	}
	
	
	
	private void checkArgument(List<?> recordInfos) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}			
	}
	
	
	
	private boolean shouldValidade(List<?> recordInfos, String paramValue) {		
		if (recordInfos.isEmpty())
			return false;
		
		if (paramValue == null)
			return false;	
		
		return true;
	}
	
	
	
	private boolean isValid(Object recordInfo, String fieldName, String paramValue) {
		try {
			Field field = recordInfo.getClass().getDeclaredField(fieldName);
			
			if (field.get(recordInfo) == null) 
				return true;			
			
			String fieldValue = String.valueOf(field.get(recordInfo));			
			return fieldValue.equals(paramValue);
		
		} catch (Exception e) {
			return true;
		} 
	}
	
	
	
	private static void logException(Exception e) {
		Logger logger = LogManager.getLogger(ModelHelper.class);
		logger.error(e.getMessage(), e);
	}
}
