package br.com.gda.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.model.decisionTree.DeciResult;

public abstract class ModelResponseTemplate<T> implements ModelResponse<T> {
	private final boolean RESULT_FAILED = false;	
	private List<DeciResult<T>> deciResults;
	
	
	protected ModelResponseTemplate() {
		deciResults = new ArrayList<>();
	}
	
	
	
	@Override public void addTreeResults(List<DeciResult<T>> results) {
		checkArgument(results);
		
		for (DeciResult<T> eachResult : results) {
			addTreeResult(eachResult);
		}
	}
	
	
	
	@Override public void addTreeResult(DeciResult<T> result) {
		checkArgument(result);
		deciResults.add(result);
	}

	
	
	@Override public Response build() {
		checkState();
		return buildResponse(deciResults);
	}
	
	
	
	private Response buildResponse(List<DeciResult<T>> results) {
		DeciResult<T> lastResult = getLastResult(deciResults);
		
		if (lastResult.isSuccess() == RESULT_FAILED) 
			return buildResponseFailed(lastResult);		
		

		return buildResponseSuccess(results);
	}
	
	
	
	private Response buildResponseFailed(DeciResult<T> result) {
		Response.Status htmlStatus = Response.Status.BAD_REQUEST;
		
		if (result.getFailCode() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
			htmlStatus = Response.Status.INTERNAL_SERVER_ERROR;
		
		return buildResponse(result.getFailMessage(), result.getFailCode(), htmlStatus);
	}
	
	
	
	private Response buildResponseSuccess(List<DeciResult<T>> results) {
		List<T> allResultsets = collectAllResultsets(results);		
		
		return buildResponse(SystemMessage.RETURNED_SUCCESSFULLY, 
				             Response.Status.OK.getStatusCode(), 
				             Response.Status.OK, 
				             allResultsets);
	}
	
	
	
	private List<T> collectAllResultsets(List<DeciResult<T>> results) {
		List<T> allResultsets = new ArrayList<>();
		
		for (DeciResult<T> eachResult : results) {
			if (eachResult.hasResultset()) {
				List<T> eachResultset = eachResult.getResultset();
				allResultsets.addAll(eachResultset);
			}
		}
		
		return allResultsets;
	}
	
	
	
	private Response buildResponse(String msg, int msgCode, Response.Status htmlStatus) {		
		return buildResponse(msg, msgCode, htmlStatus, new Object());
	}
	
	
	
	private Response buildResponse(String msg, int msgCode, Response.Status htmlStatus, Object bodyMsg) {
		JsonResponseMaker jsonMaker = getJsonReponseParserHook();
		return jsonMaker.makeResponse(msg, msgCode, htmlStatus, bodyMsg);
	}	
	
	
	
	protected JsonResponseMaker getJsonReponseParserHook() {
		//Template method to be overridden by subclasses
		logExceptionWithSupperClass(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> getLastResult(List<DeciResult<T>> results) {
		int lasElem = results.size() - 1;		
		return results.get(lasElem);
	}	
	
	
	
	private void checkArgument(List<DeciResult<T>> results) {
		if (results == null) {
			logException(new NullPointerException("results" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("results" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(DeciResult<T> result) {
		if (result == null) {
			logException(new NullPointerException("result" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("result" + SystemMessage.NULL_ARGUMENT);
		}	
	}
	
	
	
	private void checkState() {
		if (deciResults.isEmpty())
			logException(new IllegalStateException("No results added"));
			throw new IllegalStateException("No results added");
	}
	
	
	
	protected Class<?> getImplamentationClassHook() {
		//Template method to be overridden by subclasses
		logExceptionWithSupperClass(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void logException(Exception e) {
		Class<?> clazz = getImplamentationClassHook();
		
		Logger logger = LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
	}
	
	
	
	private void logExceptionWithSupperClass(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
