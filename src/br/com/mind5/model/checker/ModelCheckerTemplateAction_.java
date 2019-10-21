package br.com.mind5.model.checker;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;

public abstract class ModelCheckerTemplateAction_<T> implements ModelChecker<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	protected final boolean ALREADY_EXIST = true;
	protected final boolean NOT_FOUND = false;
	protected final boolean EMPTY_RESULTSET = false;
	protected final String NO_FAIL_MSG = null;
	protected final int NO_FAIL_CODE = -1;
	
	private String failMsg;
	private int failCode;
	private Boolean actualResult;
	private boolean expectedResult;
	private Connection conn;
	private String schemaName;
	private ActionStd<T> action;
	
	
	
	protected ModelCheckerTemplateAction_() {
		this(new ModelCheckerOption());
	}
	
	
	
	protected ModelCheckerTemplateAction_(ModelCheckerOption option) {
		checkArgument(option);
		init(option);
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
	}
	
	
	
	private void init(ModelCheckerOption option) {
		failMsg = NO_FAIL_MSG;
		failCode = NO_FAIL_CODE;
		expectedResult = option.expectedResult;
		conn = option.conn;
		schemaName = option.schemaName;
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
	
	
	
	private void checkArgument(List<T> recordInfos) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		}
	}	

	
	
	@Override public boolean check(T recordInfo) {
		action = buildActionHook(recordInfo, conn, schemaName);		
		DeciResult<T> actionResult = executeAction(action);	
		parseActionResult(actionResult);
		
		return getResult();
	}
	
	
	
	protected ActionStd<T> buildActionHook(T recordInfo, Connection conn, String schemaName) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	private DeciResult<T> executeAction(ActionStd<T> execAction) {
		 checkArgument(execAction);
		 
		 execAction.executeAction();
		 return execAction.getDecisionResult();
	}
	
	
	
	private void checkArgument(ActionStd<T> action) {
		if (action == null) {
			logException(new NullPointerException("action" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("action" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void parseActionResult(DeciResult<T> result) {
		boolean checkerResult = checkActionResult(result);
		int recordCount = getRecordCount(result);		
		
		if (hasPassed(checkerResult, recordCount)) {
			makeSuccessResult();			
		} else {
			makeFailResult(checkerResult);
		}
	}
	
	
	
	private boolean checkActionResult(DeciResult<T> result) {	
		if (result.isSuccess() == FAILED &&
			result.getFailCode() == SystemCode.INTERNAL_ERROR) {
			
			logException(new IllegalStateException(SystemMessage.INTERNAL_ERROR));
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
		
		
		if (result.isSuccess() == SUCCESS && result.getResultset().isEmpty())
			return NOT_FOUND;
		
		
		return result.isSuccess();			
	}
	
	
	
	private int getRecordCount(DeciResult<T> result) {
		int recordCount = DefaultValue.number();
		
		if (result.hasResultset())
			recordCount = result.getResultset().size();
		
		return recordCount;
	}
	
	
	
	private boolean hasPassed(boolean checkerResult, int recordCount) {
		boolean copyResult = checkerResult;
		int copyCount = recordCount;
		
		return hasPassedHook(copyResult, copyCount);
	}
	
	
	
	protected boolean hasPassedHook(boolean checkerResult, int recordCount) {
		return (checkerResult == expectedResult);
	}
	
	
	
	private void makeSuccessResult() {
		actualResult = SUCCESS;
	}
	
	
	
	private void makeFailResult(boolean result) {
		failMsg = makeFailExplanationHook(result);
		failCode = makeFailCodeHook(result);
		actualResult = FAILED;
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
	
	
	
	protected String makeFailExplanationHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected int makeFailCodeHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	//TODO: Mover para dentro "makeFailureExplanationHook" e tornar o padrao ?
	protected String getActionFailExplanation() {
		return action.getDecisionResult().getFailMessage();
	}
	
	
	
	protected int getActionFailCode() {
		return action.getDecisionResult().getFailCode();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
