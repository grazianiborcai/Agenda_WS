package br.com.mind5.model.decisionTree.temp;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

final class DeciResultHelperV2<T extends InfoRecord> implements DeciResult<T> {
	private List<T> results;
	private String failMessage;
	private int failCode;
	private boolean isSuccess;
	private boolean hasResultset;
	
	
	public DeciResultHelperV2(List<T> records, String msg, int code, boolean success, boolean resultset) {
		results = DeciTreeUtil.copyOf(records);
		failMessage = msg;
		failCode = code;
		isSuccess = success;
		hasResultset = resultset;
	}
	
	
	
	@Override public boolean isSuccess() { 
		return isSuccess;
	}
	
	
	
	@Override public String getFailMessage() {
		if (isSuccess == false)
			return failMessage;

		 return throwErrorForMsg();
	}

	
	
	@Override public int getFailCode() {	
		if (isSuccess == false)
			return failCode;

		 return throwErrorForCode();
	}	
	
	
	
	@Override public boolean hasResultset() {		
		return hasResultset;
	}
	
	
	
	@Override public List<T> getResultset() {
		if (hasResultset)		
			return DeciTreeUtil.copyOf(results);
		
		return throwErrorForResultset();
	}
	
	
	
	private String throwErrorForMsg() {
		throwError();
		return null;
	}
	
	
	
	private int throwErrorForCode() {
		throwError();
		return 0;
	}	
	
	
	
	private List<T> throwErrorForResultset() {
		throwError();
		return null;
	}
	
	
	
	private void throwError() {
		logException(new IllegalStateException("deciResult" + SystemMessage.OBJ_NOT_INITIALIED));
		throw new IllegalStateException("deciResult" + SystemMessage.OBJ_NOT_INITIALIED);
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
