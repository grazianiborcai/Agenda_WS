package br.com.mind5.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;

public final class ActionStdHelper<T> extends ActionStdTemplate<T> {
	private List<T> records = new ArrayList<>();
	private ActionVisitor<T> visi;
	private String errorMessage;
	private int errorCode;
	
	
	public ActionStdHelper(T recordInfo, ActionVisitor<T> visitor, String failedMessage, int failedCode) {		
		super();
		checkArgument(recordInfo, visitor, failedMessage, failedCode);
		makeCopy(recordInfo);
		visi = visitor;
		errorMessage = failedMessage;
		errorCode = failedCode;
	}
	
	
	
	private void makeCopy(T recordInfo) {
		T cloned = super.makeDefensiveCopy(recordInfo);
		records.add(cloned);
	}
	
	
	
	public ActionStdHelper(List<T> recordInfos, ActionVisitor<T> visitor, String failedMessage, int failedCode) {
		super();
		checkArgument(recordInfos, visitor, failedMessage, failedCode);
		makeCopy(recordInfos);
		visi = visitor;
		errorMessage = failedMessage;
		errorCode = failedCode;
	}
	
	
	
	private void makeCopy(List<T> recordInfos) {
		records = super.makeDefensiveCopy(recordInfos);
	}
	
	
	
	private void checkArgument(List<T> recordInfos, ActionVisitor<T> visitor, String failedMessage, int failedCode) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		for (T eachRecord : recordInfos) {
			checkArgument(eachRecord, visitor, failedMessage, failedCode);
		}
	}
	
	
	
	private void checkArgument(T recordInfo, ActionVisitor<T> visitor, String failedMessage, int failedCode) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (failedMessage == null) {
			logException(new NullPointerException("failedMessage" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("failedMessage" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
		if (failedCode <= 0) {
			logException(new NullPointerException("failedCode" + SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new NullPointerException("failedCode" + SystemMessage.POSITIVE_NUM_EXPECTED);
		}	
	}
	
	
	
	@Override protected List<T> tryToExecuteActionReturnListHook() throws SQLException {
		return visi.executeTransformation(records);
	}
	
	
	
	@Override protected DeciResult<T> buildResultFailedHook() {
		return buildResultError(errorMessage, errorCode);
	}
	
	
	
	private DeciResult<T> buildResultError(String failedMessage, int failedCode) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = FAILED;
		result.failCode = failedCode;
		result.failMessage = failedMessage;
		result.hasResultset = false;
		result.resultset = null;
		
		return result;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
