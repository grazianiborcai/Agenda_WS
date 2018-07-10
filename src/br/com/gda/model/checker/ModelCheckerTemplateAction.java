package br.com.gda.model.checker;

import java.sql.Connection;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;

public abstract class ModelCheckerTemplateAction<T> implements ModelChecker<T> {
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
	private DeciAction<T> deciAction;
	
	
	
	protected ModelCheckerTemplateAction() {
		this(new ModelCheckerOption());
	}
	
	
	
	protected ModelCheckerTemplateAction(ModelCheckerOption option) {
		checkArgument(option);
		
		failMsg = NO_FAIL_MSG;
		failCode = NO_FAIL_CODE;
		expectedResult = option.expectedResult;
		conn = option.conn;
		schemaName = option.schemaName;
	}
	
	
	
	private void checkArgument(ModelCheckerOption option) {
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		
		if (option.conn == null)
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		
		if (option.schemaName == null)
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
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
		if (recordInfos == null)
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		
		if (recordInfos.isEmpty())
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
	}	

	
	
	@Override public boolean check(T recordInfo) {
		deciAction = buildActionHook(recordInfo, conn, schemaName);		
		boolean checkerResult = executeAction();		
		
		if (checkerResult != this.expectedResult) {
			this.failMsg = makeFailureExplanationHook(checkerResult);
			this.failCode = makeFailureCodeHook(checkerResult);
			actualResult = FAILED;
		
		} else {
			actualResult = SUCCESS;
		}
		
		return getResult();
	}
	
	
	
	protected DeciAction<T> buildActionHook(T recordInfo, Connection conn, String schemaName) {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	private boolean executeAction() {
		 checkArgument(deciAction);
		 
		 deciAction.executeAction();
		 DeciResult<T> actionResult = deciAction.getDecisionResult();
		 
		 return checkActionResult(actionResult);
	}
	
	
	
	private void checkArgument(DeciAction<T> action) {
		if (action == null)
			throw new NullPointerException("action" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private boolean checkActionResult(DeciResult<T> actionResult) {
		if (actionResult.hasSuccessfullyFinished() == FAILED &&
			actionResult.getFailureCode() == SystemCode.DATA_NOT_FOUND)
			return NOT_FOUND;
			
			
			if (actionResult.hasSuccessfullyFinished() == FAILED)		
				throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
				
			
			if (actionResult.hasResultset() == EMPTY_RESULTSET)
				return NOT_FOUND;
			
			
			if (actionResult.getResultset().isEmpty())
				return NOT_FOUND;
			
			
			return ALREADY_EXIST;
	}
	
	
	//TODO: remover esse método
	protected boolean checkHook(T recordInfo, Connection conn, String schemaName) {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public boolean getResult() {
		if (this.actualResult == null)
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		
		return this.actualResult;
	}
	
	
	
	@Override public String getFailureExplanation() {
		if (this.failMsg == NO_FAIL_MSG)
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		
		return this.failMsg;
	}
	
	
	
	@Override public int getFailureCode() {
		if (this.failCode == NO_FAIL_CODE)
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		
		return this.failCode;
	}
	
	
	
	protected String makeFailureExplanationHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected int makeFailureCodeHook(boolean checkerResult) {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
}
