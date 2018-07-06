package br.com.gda.model.decisionTree;

import java.util.List;

import br.com.gda.common.DefaultValue;

public final class DeciResultHelper<T> implements DeciResult<T> {
	private final boolean FAILED = false;
	
	public List<T> resultset;
	public String failureMessage;
	public int failureCode;
	public Boolean finishedWithSuccess;
	public boolean hasResultset;
	
	
	public DeciResultHelper() {
		clear();
	}
	
	
	
	public void copyWithoutResultset(DeciResult<?> deciResult) {
		if (deciResult == null)
			return;		
		
		clear();
		
		if (deciResult.hasSuccessfullyFinished() == FAILED) {
			failureMessage = deciResult.getFailureMessage();
			failureCode = deciResult.getFailureCode();
		}
		
		finishedWithSuccess = deciResult.hasSuccessfullyFinished();
		hasResultset = deciResult.hasResultset();
	}
	
	
	
	private void clear() {
		resultset = null;
		failureMessage = null;
		failureCode = DefaultValue.number();
		finishedWithSuccess = null;
		hasResultset = false;
	}
	
	
	
	public boolean hasSuccessfullyFinished() {
		if (this.finishedWithSuccess == null)
			throw new IllegalStateException();
		
		return this.finishedWithSuccess;
	}
	
	
	
	public String getFailureMessage() {
		if (this.failureMessage == null)
			throw new IllegalStateException();
		
		return this.failureMessage;
	}

	
	
	public int getFailureCode() {
		if (this.failureCode < 0)
			throw new IllegalStateException();
		
		return this.failureCode;
	}	
	
	
	
	public boolean hasResultset() {		
		return this.hasResultset;
	}
	
	
	
	public List<T> getResultset() {
		if (hasResultset() == false)
			throw new IllegalStateException();
		
		return this.resultset;
	}
	
	
	
	public void copyFrom(DeciResult<T> sourceResult) {
		clear();
		
		finishedWithSuccess = sourceResult.hasSuccessfullyFinished();
		
		if (sourceResult.hasSuccessfullyFinished() == false) {
			failureMessage = sourceResult.getFailureMessage();
			failureCode = sourceResult.getFailureCode();
		}
		
		hasResultset = sourceResult.hasResultset();

		if (sourceResult.hasResultset()) 
			resultset = sourceResult.getResultset();
	}
}
