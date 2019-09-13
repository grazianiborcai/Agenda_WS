package br.com.gda.message.sysLog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Syslog {
	private Class<?> childClazz;
	
	
	protected Syslog() {
		this(Syslog.class);
	}
	
	
	
	protected Syslog(Class<?> clazz) {
		childClazz = clazz;
	}
	
	
	
	protected void logException(Exception e) {
		logException(e, childClazz);
	}
	
	
	
	protected void logException(Exception e, Class<?> clazz) {
		Logger logger = LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
	}
}
