package br.com.mind5.model.decisionTree;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class DeciResultHelper<T extends InfoRecord> implements DeciResult<T> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	public List<T> resultset;
	public String failMessage;
	public int failCode;
	public Boolean isSuccess;
	public boolean hasResultset;
	
	
	public DeciResultHelper() {
		clear();
	}
	
	
	
	public void copyFrom(DeciResult<T> source) {
		checkArgument(source);	
		clear();
		
		isSuccess = source.isSuccess();
		
		if (source.isSuccess() == false) {
			failMessage = source.getFailMessage();
			failCode = source.getFailCode();
		}
		
		hasResultset = source.hasResultset();

		if (source.hasResultset())
			resultset = makeClone(source.getResultset());
	}
	
	
	
	public void copyWithoutResultset(DeciResult<?> source) {
		checkArgument(source);			
		clear();
		
		if (source.isSuccess() == SUCCESS)
			buildSuccessMessage(source);
		
		if (source.isSuccess() == FAILED)
			buildFailMessage(source);		
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
	
	
	
	private void clear() {
		resultset = null;
		failMessage = null;
		failCode = DefaultValue.number();
		isSuccess = null;
		hasResultset = false;
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	private void checkArgument(DeciResult<?> deciResult) {
		if (deciResult == null) {
			logException(new NullPointerException("deciResult" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("deciResult" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
