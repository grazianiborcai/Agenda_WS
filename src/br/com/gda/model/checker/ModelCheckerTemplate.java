package br.com.gda.model.checker;

import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class ModelCheckerTemplate<T> implements ModelChecker<T> {
	protected final boolean RESULT_SUCCESS = true;
	protected final boolean RESULT_FAILED = false;
	
	private String failMsg;
	private int failCode;
	private Boolean actualResult;
	private boolean expectedResult;
	
	
	protected ModelCheckerTemplate() {
		this(true);
	}
	
	
	
	protected ModelCheckerTemplate(boolean expectedResult) {
		this.failMsg = null;
		this.failCode = -1;
		this.expectedResult = expectedResult;
	}
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		if (recordInfos == null)
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		
		if (recordInfos.isEmpty())
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (T eachRecordInfo : recordInfos) {
			boolean checkerResult = check(eachRecordInfo);
			
			if (checkerResult == RESULT_FAILED)
				return checkerResult;
		}
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override public boolean check(T recordInfo) {
		boolean checkerResult = checkHook(recordInfo);
		actualResult = RESULT_SUCCESS;
		
		if (checkerResult != this.expectedResult) {
			this.failMsg = makeFailureExplanationHook(checkerResult);
			this.failCode = makeFailureCodeHook(checkerResult);
			actualResult = RESULT_FAILED;
		}
		
		return getResult();
	}
	
	
	
	protected boolean checkHook(T recordInfo) {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public boolean getResult() {
		if (this.actualResult == null)
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		
		return this.actualResult;
	}
	
	
	
	@Override public String getFailureExplanation() {
		if (this.failMsg == null)
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		
		return this.failMsg;
	}
	
	
	
	@Override public int getFailureCode() {
		if (this.failCode < 0)
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		
		return this.failCode;
	}
	
	
	
	protected String makeFailureExplanationHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected int makeFailureCodeHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
}
