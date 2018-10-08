package br.com.gda.model.decisionTree;

import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;

public final class DeciTreeHelper<T> implements DeciTree<T> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private List<T> recordInfos;
	private ModelChecker<T> checker;
	private DeciChoice decisionChoice;
	private DeciResultHelper<T> deciResult;
	private List<ActionStd<T>> actionsOnPassed;
	private List<ActionStd<T>> actionsOnFailed;
	

	public DeciTreeHelper(DeciTreeHelperOption<T> option) {
		checkArgument(option);
		
		this.checker = option.visitorChecker;
		this.recordInfos = option.recordInfos;
		this.actionsOnPassed = option.actionsOnPassed;
		this.actionsOnFailed = option.actionsOnFailed;
		this.decisionChoice = null;
		this.deciResult = new DeciResultHelper<>();
	}
	
	
	
	private void checkArgument(DeciTreeHelperOption<T> option) {
		if (option == null)
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (option.visitorChecker == null)
			throw new NullPointerException("option.visitorChecker" + SystemMessage.NULL_ARGUMENT);
		
		if (option.conn == null)
			throw new NullPointerException("option.connr" + SystemMessage.NULL_ARGUMENT);
		
		if (option.recordInfos == null)
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		
		if (option.recordInfos.isEmpty())
			throw new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	
	public void makeDecision() {
		boolean checkResult = checkCondition();
		
		if (checkResult == RESULT_SUCCESS)
			onPassed();
			
		if (checkResult == RESULT_FAILED)
			onFailed();		
	}
	
	
	
	private boolean checkCondition() {		
		for (T eachRecord : this.recordInfos) {
			boolean resultChecker = this.checker.check(eachRecord);
			
			if (resultChecker == RESULT_FAILED) 
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}
	
	
		
	private void onPassed() {
		this.decisionChoice = DeciChoice.PASSED;		
		this.deciResult.finishedWithSuccess = RESULT_SUCCESS;
		executeDecisionActions(this.actionsOnPassed);
	}
	
	
	
	private void onFailed() {
		this.decisionChoice = DeciChoice.FAILED;
		this.deciResult.finishedWithSuccess = RESULT_FAILED;
		buildFailureMessage();
		executeDecisionActions(this.actionsOnFailed);		
	}
	
	
	
	private void buildFailureMessage() {		
		this.deciResult.failureCode = this.checker.getFailureCode();
		this.deciResult.failureMessage = this.checker.getFailureExplanation();
	}
	
	
	
	private void executeDecisionActions(List<ActionStd<T>> decisionActions) {
		if (decisionActions == null)
			return;
			
		for (ActionStd<T> eachAction : decisionActions) {
			eachAction.executeAction();
			DeciResult<T> actionResult = eachAction.getDecisionResult();		
			buildResultFromAction(actionResult);
			
			if (actionResult.hasSuccessfullyFinished() == RESULT_FAILED)
				break;
		}
	}
	
	
	
	private void buildResultFromAction(DeciResult<T> actionResult) {
		this.deciResult.finishedWithSuccess = actionResult.hasSuccessfullyFinished();
		if (this.deciResult.finishedWithSuccess == RESULT_FAILED) {
			this.deciResult.failureCode = actionResult.getFailureCode();
			this.deciResult.failureMessage = actionResult.getFailureMessage();
		}
		
		
		this.deciResult.hasResultset = actionResult.hasResultset();
		if (actionResult.hasResultset()) {
			this.deciResult.resultset = actionResult.getResultset();
		}
		
		
		if (this.deciResult.hasResultset()) {
			if (this.deciResult.resultset == null || this.deciResult.resultset.isEmpty()) {
				this.deciResult.finishedWithSuccess = RESULT_FAILED;
				this.deciResult.failureCode = SystemCode.DATA_NOT_FOUND;
				this.deciResult.failureMessage = SystemMessage.DATA_NOT_FOUND;
			}
		}
	}
	
	
	
	public DeciChoice getDecisionMade() {
		return this.decisionChoice;
	}


	
	public DeciResult<T> getDecisionResult() {
		return this.deciResult;
	}
	
	
	
	@Override public ActionStd<T> toAction() {
		return new DeciTreeAdapter<>(this);
	}
}
