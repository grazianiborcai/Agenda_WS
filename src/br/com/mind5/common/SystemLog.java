package br.com.mind5.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SystemLog {
	
	static public void logError(Class<?> clazz, Exception e) {
		Logger logger =  LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
		logger = null;
	}
}
