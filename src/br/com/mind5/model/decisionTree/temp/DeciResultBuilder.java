package br.com.mind5.model.decisionTree.temp;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

public final class DeciResultBuilder<T extends InfoRecord> {
	private List<T> results;
	private String failMessage;
	private int failCode;
	
	
	public static <T extends InfoRecord> DeciResult<T> copyOf(DeciResult<T> source) {
		 DeciResultBuilder<T> builder = new  DeciResultBuilder<>();
		 
		 if (source == null)
			 return builder.build();
		 
		 if (source.hasResultset())
			 builder.addResults(source.getResultset());
		 
		 if (source.isSuccess() == false) {
			 builder.addFailCode(source.getFailCode());
			 builder.addFailMessage(source.getFailMessage());
		 }		 
		 
		 return builder.build();
	}
	
	
	public DeciResultBuilder() {
		failCode = 0;
	}
	
	
	
	public synchronized void addResults(List<T> records) {
		if (isArgumentValid(records))
			results = DeciTreeUtil.copyOf(records);
		
		results = null;
	}
	
	
	
	public synchronized void addFailMessage(String msg) {
		failMessage = msg;
	}
	
	
	
	public synchronized void addFailCode(int code) {
		failCode = code;
	}
	
	
	
	public synchronized DeciResult<T> build() {
		if (isFailed(failMessage, failCode))
			return buildFailed(failMessage, failCode);

		if (isSuccess(results))	
			return buildSuccess(results);
		
		throwError();
		return null;
	}
	
	
	
	private DeciResult<T> buildFailed(String msg, int code) {
		checkFailed(msg, code);
		
		List<T> resultset = null;
		boolean isSuccess = false;
		boolean hasResultset = false;
		
		return new DeciResultHelperV2<>(resultset, msg, code, isSuccess, hasResultset);
	}
	
	
	
	private DeciResult<T> buildSuccess(List<T> records) {
		checkSuccess(records);
		
		List<T> resultset = DeciTreeUtil.copyOf(records);
		boolean isSuccess = true;
		boolean hasResultset = true;
		String msg = null;
		int code = 0;
		
		return new DeciResultHelperV2<>(resultset, msg, code, isSuccess, hasResultset);
	}
	
	
	
	private void checkFailed(String msg, int code) {
		if (isArgumentValid(msg) == false) {
			logException(new NullPointerException("failMessage" + SystemMessage.ILLEGAL_ARGUMENT));
			throw new NullPointerException("failMessage" + SystemMessage.ILLEGAL_ARGUMENT);
		}
		
		
		if (isArgumentValid(code) == false) {
			logException(new NullPointerException("failCode" + SystemMessage.ILLEGAL_ARGUMENT));
			throw new NullPointerException("failCode" + SystemMessage.ILLEGAL_ARGUMENT);
		}
	}	
	
	
	
	private void checkSuccess(List<T> records) {
		if (isArgumentValid(records) == false) {
			logException(new NullPointerException("results" + SystemMessage.ILLEGAL_ARGUMENT));
			throw new NullPointerException("results" + SystemMessage.ILLEGAL_ARGUMENT);
		}
	}
	
	
	
	private boolean isFailed(String msg, int code) {
		if (isArgumentValid(msg) || isArgumentValid(code))
			return true;
		
		return false;
	}
	
	
	
	private boolean isSuccess(List<T> records) {
		if (isArgumentValid(records))
			return true;
		
		return false;
	}
	
	
	
	private boolean isArgumentValid(List<T> records) {
		if (records == null)
			return false;
		
		if (records.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private boolean isArgumentValid(String msg) {
		if (msg == null)
			return false;
		
		return true;
	}	
	
	
	
	private boolean isArgumentValid(int code) {
		if (code <= 0)
			return false;
		
		return true;
	}	
	
	
	
	private void throwError() {
		logException(new NullPointerException(SystemMessage.ILLEGAL_ARGUMENT));
		throw new NullPointerException(SystemMessage.ILLEGAL_ARGUMENT);
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}	
}
