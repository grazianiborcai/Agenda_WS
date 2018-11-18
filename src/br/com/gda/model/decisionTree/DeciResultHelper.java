package br.com.gda.model.decisionTree;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;

public final class DeciResultHelper<T> implements DeciResult<T> {
	private final boolean FAIL = false;
	private final boolean SUCCESS = true;
	
	public List<T> resultset;
	public String failMessage;
	public int failCode;
	public Boolean isSuccess;
	public boolean hasResultset;
	
	
	public DeciResultHelper() {
		clear();
	}
	
	
	
	public void copyWithoutResultset(DeciResult<?> deciResult) {
		checkArgument(deciResult);			
		clear();
		
		if (deciResult.isSuccess() == SUCCESS)
			buildSuccessMessage(deciResult);
		
		if (deciResult.isSuccess() == FAIL)
			buildFailMessage(deciResult);		
	}
	
	
	
	private void checkArgument(DeciResult<?> deciResult) {
		if (deciResult == null) {
			logException(new NullPointerException("deciResult" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("deciResult" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void buildSuccessMessage(DeciResult<?> deciResult) {
		isSuccess = deciResult.isSuccess();
		hasResultset = deciResult.hasResultset();
	}
	
	
	
	private void buildFailMessage(DeciResult<?> deciResult) {
		isSuccess = deciResult.isSuccess();
		failMessage = deciResult.getFailMessage();
		failCode = deciResult.getFailCode();
	}
	
	
	
	public boolean isSuccess() { 
		checkState(isSuccess);		
		return isSuccess;
	}
	
	
	
	private void checkState(Boolean state) {
		if (state == null)
			illegalState();
	}
	
	
	
	public String getFailMessage() {
		checkState(failMessage);
		return failMessage;
	}
	
	
	
	private void checkState(String state) {
		if (state == null)
			illegalState();
	}

	
	
	public int getFailCode() {
		checkState(failCode);		
		return failCode;
	}	
	
	
	
	private void checkState(int state) {
		if (state < 0)
			illegalState();
	}
	
	
	
	public boolean hasResultset() {		
		return hasResultset;
	}
	
	
	
	public List<T> getResultset() {
		checkState(hasResultset());
		return resultset;
	}
	
	
	
	private void checkState(boolean state) {
		if (state == false)
			illegalState();
	}
	
	
	
	private void illegalState() {
		logException(new IllegalStateException("deciResult" + SystemMessage.OBJ_NOT_INITIALIED));
		throw new IllegalStateException("deciResult" + SystemMessage.OBJ_NOT_INITIALIED);
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
	
	
	
	private void clear() {
		resultset = null;
		failMessage = null;
		failCode = DefaultValue.number();
		isSuccess = null;
		hasResultset = false;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
