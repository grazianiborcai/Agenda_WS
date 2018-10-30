package br.com.gda.model.decisionTree;

import java.util.List;

import br.com.gda.common.DefaultValue;

public final class DeciResultHelper<T> implements DeciResult<T> {
	private final boolean FAILED = false;
	
	public List<T> resultset;
	public String failMessage;
	public int failCode;
	public Boolean isSuccess;
	public boolean hasResultset;
	
	
	public DeciResultHelper() {
		clear();
	}
	
	
	
	public void copyWithoutResultset(DeciResult<?> deciResult) {
		if (deciResult == null)
			return;		
		
		clear();
		
		if (deciResult.isSuccess() == FAILED) {
			failMessage = deciResult.getFailMessage();
			failCode = deciResult.getFailCode();
		}
		
		isSuccess = deciResult.isSuccess();
		hasResultset = deciResult.hasResultset();
	}
	
	
	
	private void clear() {
		resultset = null;
		failMessage = null;
		failCode = DefaultValue.number();
		isSuccess = null;
		hasResultset = false;
	}
	
	
	
	public boolean isSuccess() {
		if (this.isSuccess == null)
			throw new IllegalStateException();
		
		return this.isSuccess;
	}
	
	
	
	public String getFailMessage() {
		if (this.failMessage == null)
			throw new IllegalStateException();
		
		return this.failMessage;
	}

	
	
	public int getFailCode() {
		if (this.failCode < 0)
			throw new IllegalStateException();
		
		return this.failCode;
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
		
		isSuccess = sourceResult.isSuccess();
		
		if (sourceResult.isSuccess() == false) {
			failMessage = sourceResult.getFailMessage();
			failCode = sourceResult.getFailCode();
		}
		
		hasResultset = sourceResult.hasResultset();

		if (sourceResult.hasResultset()) 
			resultset = sourceResult.getResultset();
	}
}
