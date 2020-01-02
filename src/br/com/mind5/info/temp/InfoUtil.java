package br.com.mind5.info.temp;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.info.InfoRecord;

public final class InfoUtil {
	public static <T extends InfoRecord> List<T> copy(T baseInfo) {		
		try {
			List<T> baseInfos = new ArrayList<>();
			baseInfos.add(baseInfo);			
			return defensiveCopyBase(baseInfos);
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new InternalError(e);
		}
	}
	
	
	
	public static <T extends InfoRecord> List<T> copy(List<T> baseInfos) {		
		try {
			return defensiveCopyBase(baseInfos);
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new InternalError(e);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static <T extends InfoRecord> List<T> defensiveCopyBase(List<T> baseInfos) throws CloneNotSupportedException {
		List<T> copies = new ArrayList<>();
		
		for (T eachBase : baseInfos) {			
			T eachCopy = (T) eachBase.clone();
			copies.add(eachCopy);
		}
		
		return copies;
	}
	
	
	
	private static void logException(Exception e) {
		Logger logger = LogManager.getLogger(InfoUtil.class);
		logger.error(e.getMessage(), e);
	}
}
