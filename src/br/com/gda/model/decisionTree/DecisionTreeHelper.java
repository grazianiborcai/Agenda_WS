package br.com.gda.model.decisionTree;

import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelChecker;

public final class DecisionTreeHelper<T> implements DecisionTree<T> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private List<T> recordInfos;
	private ModelChecker<T> checker;
	private DecisionChoice decisionChoice;
	private DecisionResultHelper<T> decisionResult;
	private List<DecisionActionAdapter<T>> actionsOnPassed;
	private List<DecisionActionAdapter<T>> actionsOnFailed;
	

	public DecisionTreeHelper(DecisionTreeHelperOption<T> option) {
		if (option == null)
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (option.visitorChecker == null)
			throw new NullPointerException("option.visitorChecker" + SystemMessage.NULL_ARGUMENT);
		
		if (option.recordInfos == null)
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		
		if (option.recordInfos.isEmpty())
			throw new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		
		
		this.checker = option.visitorChecker;
		this.recordInfos = option.recordInfos;
		this.actionsOnPassed = option.actionsOnPassed;
		this.actionsOnFailed = option.actionsOnFailed;
		this.decisionChoice = null;
		this.decisionResult = new DecisionResultHelper<>();
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
		this.decisionChoice = DecisionChoice.PASSED;		
		this.decisionResult.finishedWithSuccess = RESULT_SUCCESS;
		executeDecisionAction(this.actionsOnPassed);
	}
	
	
	
	private void onFailed() {
		this.decisionChoice = DecisionChoice.FAILED;
		this.decisionResult.finishedWithSuccess = RESULT_FAILED;
		buildFailureMessage();
		executeDecisionAction(this.actionsOnFailed);		
	}
	
	
	
	private void buildFailureMessage() {		
		this.decisionResult.failureCode = this.checker.getFailureCode();
		this.decisionResult.failureMessage = this.checker.getFailureExplanation();
	}
	
	
	
	private void executeDecisionAction(List<DecisionActionAdapter<T>> decisionActions) {
		if (decisionActions == null)
			return;
			
		for (DecisionActionAdapter<T> eachAction : decisionActions) {
			eachAction.executeAction();
			DecisionResult<T> actionResult = eachAction.getDecisionResult();		
			buildResultFromAction(actionResult);
			
			if (actionResult.hasSuccessfullyFinished() == RESULT_FAILED)
				break;
		}
	}
	
	
	
	private void buildResultFromAction(DecisionResult<T> decisionActionResult) {
		this.decisionResult.finishedWithSuccess = decisionActionResult.hasSuccessfullyFinished();
		if (this.decisionResult.finishedWithSuccess == RESULT_FAILED) {
			this.decisionResult.failureCode = decisionActionResult.getFailureCode();
			this.decisionResult.failureMessage = decisionActionResult.getFailureMessage();
		}
		
		this.decisionResult.hasResultset = decisionActionResult.hasResultset();
		if (decisionActionResult.hasResultset() == true) {
			this.decisionResult.resultset = decisionActionResult.getResultset();
		}
	}
	
	
	
	public DecisionChoice getDecisionMade() {
		return this.decisionChoice;
	}


	
	public DecisionResult<T> getDecisionResult() {
		return this.decisionResult;
	}
}
