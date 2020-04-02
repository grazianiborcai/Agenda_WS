package br.com.mind5.common;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class CloneUtil {
	
	public static <T extends InfoRecord> List<T> cloneRecords(List<T> recordInfos, Class<?> callerClazz) {
		if (recordInfos == null)
			return null;
		
		List<T> results = new ArrayList<>();
		
		for (T eachRecord : recordInfos) {
			T cloned = cloneRecord(eachRecord, callerClazz);
			results.add(cloned);
		}
		
		return results;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static <T extends InfoRecord> T cloneRecord(T recordInfo, Class<?> callerClazz) {
		try {
			if (recordInfo == null)
				return null;
			
			return (T) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e, callerClazz);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private static void logException(Exception e, Class<?> callerClazz) {
		 Class<?> clazz = callerClazz;
		 
		 if (clazz == null)
			 clazz = CloneUtil.class;
		
		SystemLog.logError(clazz, e);
	}
}
