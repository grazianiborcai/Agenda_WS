package br.com.gda.json;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public abstract class JsonHelperTemplate<T> implements JsonHelper<T> {
	private final JsonBodyParser<T> parser;
	private final JsonResponse response;
	private final Class<?> iClass;
	
	
	protected JsonHelperTemplate(JsonBodyParser<T> jParser, JsonResponse jResponse, Class<?> iClazz) {
		checkArgument(jParser, jResponse, iClazz);
		
		parser = jParser;
		response = jResponse;
		iClass = iClazz;
	}
	
	
	
	@Override public List<T> parse(String incomingData) {
		return parser.parse(incomingData);
	}
	
	
	
	@Override public Response makeResponse(String msg, Response.Status htmlStatus, Object dataObj) {
		return response.makeResponse(msg, htmlStatus, dataObj);
	}
	
	
	
	public Response makeResponse(String msg, int msgCode, Response.Status htmlStatus, Object dataObj) {
		return response.makeResponse(msg, msgCode, htmlStatus, dataObj);
	}
	
	
	
	private void checkArgument(JsonBodyParser<T> jParser, JsonResponse jResponse, Class<?> iClazz) {
		if (jParser == null) {
			logException(new NullPointerException("jParser" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("jParser" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (jResponse == null) {
			logException(new NullPointerException("jResponse" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("jResponse" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
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
