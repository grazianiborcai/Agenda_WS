package br.com.gda.model.checker;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.message.sysMessage.info.SymsgInfo;

public abstract class ModelCheckerTemplateSimpleV2<T> implements ModelChecker<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	protected final String NO_FAIL_MSG = null;
	protected final int NO_FAIL_CODE = -1;
	
	private String failMsg;
	private int failCode;
	private Boolean checkResult;
	private boolean expectedResult;
	private Connection conn;
	private String schemaName;
	private SymsgInfo symsgData;
	
	
	
	protected ModelCheckerTemplateSimpleV2(ModelCheckerOption option) {
		checkArgument(option);
		
		failMsg = NO_FAIL_MSG;
		failCode = NO_FAIL_CODE;
		expectedResult = option.expectedResult;
		conn = option.conn;
		schemaName = option.schemaName;
		symsgData = DefaultValue.object();
	} 
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		checkArgument(recordInfos);				
		
		for (T eachRecordInfo : recordInfos) {
			boolean checkerResult = check(eachRecordInfo);
			
			if (checkerResult == FAILED)
				return checkerResult;
		}
		
		return SUCCESS;
	}
	
	
	
	@Override public boolean check(T recordInfo) {
		checkArgument(recordInfo);
		
		boolean result = checkHook(recordInfo, conn, schemaName);
		checkResult = SUCCESS;
		
		if (result != expectedResult) {
			failMsg = makeFailureExplanationHook(result);
			failCode = makeFailureCodeHook(result);
			checkResult = FAILED;
		}
		
		return getResult();
	}
	
	
	
	protected boolean checkHook(T recordInfo, Connection conn, String schemaName) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public boolean getResult() {
		if (this.checkResult == null) {
			logException(new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED));
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		}
		
		return this.checkResult;
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
	
	
	
	private SymsgInfo getMessage(boolean checkerResult) {
		int codMsg = getMessageCodeHook(checkerResult);
		
	}
	
	
	
	protected String makeFailureExplanationHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected int getMessageCodeHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void checkArgument(ModelCheckerOption option) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
		if (option.codLanguage == null) {
			logException(new NullPointerException("option.codLanguage" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.codLanguage" + SystemMessage.NULL_ARGUMENT);
		}			
	}
	
	
	
	private void checkArgument(List<T> recordInfos) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
