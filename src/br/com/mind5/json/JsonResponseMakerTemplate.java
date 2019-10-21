package br.com.mind5.json;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public abstract class JsonResponseMakerTemplate implements JsonResponseMaker {
	private final Class<?> iClass;
	
	
	protected JsonResponseMakerTemplate(Class<?> iClazz) {
		checkArgument(iClazz);		
		iClass = iClazz;
	}
	
	
	
	@Override public Response makeResponse(String msg, Response.Status htmlStatus, Object dataObj) {
		checkArgument(msg, htmlStatus, dataObj);
		return makeResponseHook(msg, htmlStatus.getStatusCode(), htmlStatus, dataObj);
	}
	
	
	
	@Override public Response makeResponse(String msg, int msgCode, Response.Status htmlStatus, Object dataObj) {
		checkArgument(msg, msgCode, htmlStatus, dataObj);
		return makeResponseHook(msg, msgCode, htmlStatus, dataObj);
	}
	
	
	
	protected Response makeResponseHook(String msg, int msgCode, Response.Status htmlStatus, Object dataObj) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void checkArgument(String msg, int msgCode, Response.Status htmlStatus, Object dataObj) {
		if (msgCode <= 0) {
			logException(new NullPointerException("msgCode" + SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new NullPointerException("msgCode" + SystemMessage.POSITIVE_NUM_EXPECTED);
		}	
		
		
		checkArgument(msg, htmlStatus, dataObj);
	}
	
	
	
	private void checkArgument(String msg, Response.Status htmlStatus, Object dataObj) {		
		if (msg == null) {
			logException(new NullPointerException("msg" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("msg" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
		if (htmlStatus == null) {
			logException(new NullPointerException("htmlStatus" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("htmlStatus" + SystemMessage.NULL_ARGUMENT);
		}		
		
		
		if (dataObj == null) {
			logException(new NullPointerException("dataObj" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("dataObj" + SystemMessage.NULL_ARGUMENT);
		}		
	}	
	
	
	
	private void checkArgument(Class<?> iClazz) {		
		if (iClazz == null) {
			logException(new NullPointerException("iClazz" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("iClazz" + SystemMessage.NULL_ARGUMENT);
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
