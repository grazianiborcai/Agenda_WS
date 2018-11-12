package br.com.gda.model.checker;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public abstract class ModelCheckerTemplateSimple<T> implements ModelChecker<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	protected final String NO_FAIL_MSG = null;
	protected final int NO_FAIL_CODE = -1;
	
	private String failMsg;
	private int failCode;
	private Boolean actualResult;
	private boolean expectedResult;
	private Connection conn;
	private String schemaName;
	
	
	
	protected ModelCheckerTemplateSimple() {
		this(new ModelCheckerOption());
	}
	
	
	
	protected ModelCheckerTemplateSimple(ModelCheckerOption option) {
		this.failMsg = NO_FAIL_MSG;
		this.failCode = NO_FAIL_CODE;
		this.expectedResult = option.expectedResult;
		this.conn = option.conn;
		this.schemaName = option.schemaName;
	} 
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		}
				
		
		for (T eachRecordInfo : recordInfos) {
			boolean checkerResult = check(eachRecordInfo);
			
			if (checkerResult == FAILED)
				return checkerResult;
		}
		
		return SUCCESS;
	}
	
	
	
	@Override public boolean check(T recordInfo) {
		boolean checkerResult = checkHook(recordInfo, this.conn, this.schemaName);
		actualResult = SUCCESS;
		
		if (checkerResult != this.expectedResult) {
			this.failMsg = makeFailureExplanationHook(checkerResult);
			this.failCode = makeFailureCodeHook(checkerResult);
			actualResult = FAILED;
		}
		
		return getResult();
	}
	
	
	
	protected boolean checkHook(T recordInfo, Connection conn, String schemaName) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public boolean getResult() {
		if (this.actualResult == null) {
			logException(new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED));
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		}
		
		return this.actualResult;
	}
	
	
	
	@Override public String getFailMessage() {
		if (this.failMsg == NO_FAIL_MSG) {
			logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		}
		
		return this.failMsg;
	}
	
	
	
	@Override public int getFailCode() {
		if (this.failCode == NO_FAIL_CODE) {
			logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		}
		
		return this.failCode;
	}
	
	
	
	protected String makeFailureExplanationHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected int makeFailureCodeHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
