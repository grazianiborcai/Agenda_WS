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
	private DecisionActionAdapter<T> actionOnPassed;
	private DecisionActionAdapter<T> actionOnFailed;
	

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
		this.actionOnPassed = option.actionOnPassed;
		this.actionOnFailed = option.actionOnFailed;
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
		executeDecisionAction(this.actionOnPassed);
	}
	
	
	
	private void onFailed() {
		this.decisionChoice = DecisionChoice.FAILED;
		this.decisionResult.finishedWithSuccess = RESULT_FAILED;
		buildFailureMessage();
		executeDecisionAction(this.actionOnFailed);		
	}
	
	
	
	private void buildFailureMessage() {		
		this.decisionResult.failureCode = this.checker.getFailureCode();
		this.decisionResult.failureMessage = this.checker.getFailureExplanation();
	}
	
	
	
	private void executeDecisionAction(DecisionActionAdapter<T> decisionAction) {
		if (decisionAction == null)
			return;
			
		decisionAction.executeAction();
		DecisionResult<T> actionResult = decisionAction.getDecisionResult();		
		buildResultFromAction(actionResult);
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
