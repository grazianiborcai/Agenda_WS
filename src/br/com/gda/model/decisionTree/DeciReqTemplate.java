package br.com.gda.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class DeciReqTemplate implements DeciReq {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;	
	
	private DeciAction<?> action;
	private List<DeciPostReq> postRequests;
	private boolean hasExecuted;
	private DeciReqResu requestResult;
	
	
	public DeciReqTemplate(DeciAction<?> reqAction) {
		checkArgument(reqAction);
		
		action = reqAction;
		postRequests = new ArrayList<>();
		hasExecuted = false;
	}
	
	
	
	private void checkArgument(DeciAction<?> reqAction) {
		if (reqAction == null)
			throw new NullPointerException("reqAction" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	public boolean execute() {
		boolean result = tryToExecute();
		
		if (result == SUCCESS) 
			result = executePostRequests();	
		
		return result;
	}
	
	
	
	private boolean tryToExecute() {		
		boolean result = action.executeAction();		
		hasExecuted = true;
		
		DeciResult<?> actionResult = action.getDecisionResult();
		requestResult = tryToGetResult(actionResult);
		
		return result;
	}
	
	
	
	private DeciReqResu tryToGetResult(DeciResult<?> actionResult) {
		DeciResuTranslator resultTranslator = getTranslatorHook();		
		return new DeciReqResuHelper(actionResult, resultTranslator);
	}
	
	
	
	protected DeciResuTranslator getTranslatorHook() {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private boolean executePostRequests() {
		boolean result = true;
		
		for (DeciPostReq eachRequest : postRequests) {
			result = tryToExecutePostRequests(eachRequest);
			
			if (result == FAILED)
				return result;
		}
		
		
		return result;
	}
	
	
	
	private boolean tryToExecutePostRequests(DeciPostReq postRequest) {
		boolean result = postRequest.execute(requestResult);
		requestResult = postRequest.getResult();
		
		return result;
	}
	
	
	
	public DeciReqResu getResult() {
		checkState();
		
		return requestResult;
	}
	
	
	
	private void checkState() {
		if (hasExecuted == false)
			throw new IllegalStateException(SystemMessage.REQUEST_NOT_EXECUTED);
	}
	
	
	
	public void addPostRequest(DeciPostReq postRequest) {
		checkArgument(postRequest);
		postRequests.add(postRequest);
	}
	
	
	
	private void checkArgument(DeciPostReq postRequest) {
		if (postRequest == null)
			throw new NullPointerException("postRequest" + SystemMessage.NULL_ARGUMENT);
	}
}
