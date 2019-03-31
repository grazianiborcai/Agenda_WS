package br.com.gda.model.decisionTree;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;

public final class DeciTreeHelper<T> implements DeciTree<T> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	private final boolean EMPTY = false;
	
	private List<T> recordInfos;
	private ModelChecker<T> checker;
	private DeciChoice decisionChoice;
	private DeciResultHelper<T> deciResult;
	private List<ActionStd<T>> actionsOnPassed;
	private List<ActionStd<T>> actionsOnFailed;
	

	public DeciTreeHelper(DeciTreeHelperOption<T> option) {
		checkArgument(option);
		init(option);
	}
	
	
	
	private void checkArgument(DeciTreeHelperOption<T> option) {
		if (option == null) {
			logException(new NullPointerException("options" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.visitorChecker == null) {
			logException(new NullPointerException("option.visitorChecker" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.visitorChecker" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.actionsOnPassed == null) {
			logException(new NullPointerException("option.actionsOnPassed" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.actionsOnPassed" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos == null) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos.isEmpty()) {
			logException(new IllegalArgumentException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void init(DeciTreeHelperOption<T> option) {
		checker = option.visitorChecker;
		recordInfos = option.recordInfos;
		actionsOnPassed = option.actionsOnPassed;
		actionsOnFailed = option.actionsOnFailed;
		decisionChoice = null;
		deciResult = null;
	}
	
	
	
	public void makeDecision() {
		//TODO: loop por registro
		boolean checkResult = checkCondition(recordInfos, checker);
		
		if (checkResult == RESULT_SUCCESS)
			onPassed(actionsOnPassed);
			
		if (checkResult == RESULT_FAILED)
			onFailed(actionsOnFailed, checker);		
	}
	
	
	
	private boolean checkCondition(List<T> records, ModelChecker<T> condiChecker) {		
		for (T eachRecord : records) {
			boolean resultChecker = condiChecker.check(eachRecord);
			
			if (resultChecker == RESULT_FAILED) 
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}
	
	
		
	private void onPassed(List<ActionStd<T>> actions) {
		buildSuccessMessage();
		if (hasAction(actions))
			executeDecisionActions(actions);
	}
	
	
	
	private void buildSuccessMessage() {	
		decisionChoice = DeciChoice.PASSED;
		deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = RESULT_SUCCESS;
		deciResult.hasResultset = EMPTY; 
	}
	
	
	
	private void onFailed(List<ActionStd<T>> actions, ModelChecker<T> condiChecker) {
		buildFailureMessage(condiChecker.getFailCode(), condiChecker.getFailMessage());
		if (hasAction(actions))
			executeDecisionActions(actions);		
	}
	
	
	
	private void buildFailureMessage(int code, String explanation) {	
		decisionChoice = DeciChoice.FAILED;
		deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = RESULT_FAILED;
		deciResult.hasResultset = EMPTY;
		deciResult.failCode = code;
		deciResult.failMessage = explanation;
	}
	
	
	
	private boolean hasAction(List<ActionStd<T>> decisionActions) {
		return (decisionActions != null);
	}
	
	
	
	private void executeDecisionActions(List<ActionStd<T>> decisionActions) {			
		for (ActionStd<T> eachAction : decisionActions) {
			eachAction.executeAction();
			DeciResult<T> actionResult = eachAction.getDecisionResult();		
			buildResultFromAction(actionResult);
			
			if (actionResult.isSuccess() == RESULT_FAILED)
				break;
		}
	}
	
	

	private void buildResultFromAction(DeciResult<T> actionResult) {
		deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = actionResult.isSuccess();
		
		if (deciResult.isSuccess == RESULT_FAILED) {
			deciResult.failCode = actionResult.getFailCode();
			deciResult.failMessage = actionResult.getFailMessage();
		}
		
		
		deciResult.hasResultset = actionResult.hasResultset();
		
		if (actionResult.hasResultset()) {
			deciResult.resultset = actionResult.getResultset();
		}
		
		
		if (deciResult.hasResultset()) {
			if (deciResult.resultset == null || deciResult.resultset.isEmpty()) {
				deciResult.isSuccess = RESULT_FAILED;
				deciResult.failCode = SystemCode.DATA_NOT_FOUND;
				deciResult.failMessage = SystemMessage.DATA_NOT_FOUND;
			}
		}
	}
	
	
	
	public DeciChoice getDecisionMade() {
		return decisionChoice;
	}


	
	public DeciResult<T> getDecisionResult() {
		return deciResult;
	}
	
	
	
	@Override public ActionStd<T> toAction() {
		return new DeciTreeAdapter<>(this);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
