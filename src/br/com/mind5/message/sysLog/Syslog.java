package br.com.mind5.message.sysLog;

import br.com.mind5.common.SystemLog;

public abstract class Syslog {
	transient private Class<?> childClazz;
	
	
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
		SystemLog.logError(clazz, e);
	}
}
