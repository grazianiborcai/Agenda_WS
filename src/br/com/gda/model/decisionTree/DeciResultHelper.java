package br.com.gda.model.decisionTree;

import java.util.List;

public final class DeciResultHelper<T> implements DeciResult<T> {
	public List<T> resultset;
	public String failureMessage;
	public int failureCode;
	public Boolean finishedWithSuccess;
	public boolean hasResultset;
	
	
	public DeciResultHelper() {
		this.resultset = null;
		this.failureMessage = null;
		this.failureCode = -1;
		this.finishedWithSuccess = null;
		this.hasResultset = false;
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
}
