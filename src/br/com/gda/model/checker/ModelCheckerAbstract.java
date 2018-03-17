package br.com.gda.model.checker;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.gda.common.SystemMessage;

public abstract class ModelCheckerAbstract<T> implements ModelChecker<T> {
	protected final boolean RESULT_SUCCESS = true;
	protected final boolean RESULT_FAILED = false;
	protected final String NO_FAILURE_MSG = "";
	protected final int SUCCESS_CODE = Status.OK.getStatusCode();
	
	private String failMsg;
	private int failCode;
	private boolean expectedResult;
	
	
	protected ModelCheckerAbstract() {
		this(true);
	}
	
	
	
	protected ModelCheckerAbstract(boolean expectedResult) {
		this.failMsg = NO_FAILURE_MSG;
		this.failCode = SUCCESS_CODE;
		this.expectedResult = expectedResult;
	}
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		if (recordInfos == null)
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		
		if (recordInfos.isEmpty())
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (T eachRecordInfo : recordInfos) {
			boolean checkerResult = check(eachRecordInfo);
			
			if (checkerResult != RESULT_SUCCESS)
				return checkerResult;
		}
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override public boolean check(T recordInfo) {
		boolean checkerResult = checkHook(recordInfo);
		
		if (checkerResult != this.expectedResult) {
			this.failMsg = makeFailureExplanationHook(checkerResult);
			this.failCode = makeFailureCodeHook(checkerResult);
		}
		
		return checkerResult;
	}
	
	
	
	protected boolean checkHook(T recordInfo) {
		return RESULT_SUCCESS;
	}
	
	
	
	@Override public boolean getExpectedResult() {
		return this.expectedResult;
	}
	
	
	
	@Override public String getFailureExplanation() {
		return this.failMsg;
	}
	
	
	
	@Override public int getFailureCode() {
		return this.failCode;
	}
	
	
	
	protected String makeFailureExplanationHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		return this.failMsg;
	}
	
	
	
	protected int makeFailureCodeHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		return this.failCode;
	}
}
