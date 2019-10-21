package br.com.mind5.json;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public abstract class JsonBodyParserTemplate<T> implements JsonBodyParser<T> {
	private final Class<?> iClass;
	private final Class<T> tClass;
	
	
	protected JsonBodyParserTemplate(Class<?> iClazz, Class<T> tClazz) {
		checkArgument(iClazz, tClazz);		
		iClass = iClazz;
		tClass = tClazz;
	}
	
	
	
	@Override public List<T> parse(String incomingData) {
		checkArgument(incomingData);
		return parseHook(incomingData, tClass);
	}
	
	
	
	protected List<T> parseHook(String incomingData, Class<T> tClass) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void checkArgument(Class<?> iClazz, Class<?> tClazz) {		
		if (iClazz == null) {
			logException(new NullPointerException("iClazz" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("iClazz" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
		if (tClazz == null) {
			logException(new NullPointerException("tClazz" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("tClazz" + SystemMessage.NULL_ARGUMENT);
		}	
	}
	
	
	
	private void checkArgument(String incomingData) {
		if (incomingData == null) {
			logException(new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Class<?> clazz = iClass;
		
		if (clazz == null) 
			clazz = this.getClass();
		
		Logger logger = LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
	}
}
