package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public abstract class RecordInfo {
	
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
}
