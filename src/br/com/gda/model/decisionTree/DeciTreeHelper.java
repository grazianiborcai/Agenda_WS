package br.com.gda.model.decisionTree;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelChecker;

public final class DeciTreeHelper<T> implements DeciTree<T> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private List<T> recordInfos;
	private ModelChecker<T> checker;
	private DeciChoice decisionChoice;
	private DeciResultHelper<T> decisionResult;
	private List<DeciAction<T>> actionsOnPassed;
	private List<DeciAction<T>> actionsOnFailed;
	

	public DeciTreeHelper(DeciTreeHelperOption<T> option) {
		checkArgument(option);
		
		this.checker = option.visitorChecker;
		this.recordInfos = option.recordInfos;
		this.actionsOnPassed = option.actionsOnPassed;
		this.actionsOnFailed = option.actionsOnFailed;
		this.decisionChoice = null;
		this.decisionResult = new DeciResultHelper<>();
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
		this.decisionResult.finishedWithSuccess = RESULT_SUCCESS;
		executeDecisionActions(this.actionsOnPassed);
	}
	
	
	
	private void onFailed() {
		this.decisionChoice = DeciChoice.FAILED;
		this.decisionResult.finishedWithSuccess = RESULT_FAILED;
		buildFailureMessage();
		executeDecisionActions(this.actionsOnFailed);		
	}
	
	
	
	private void buildFailureMessage() {		
		this.decisionResult.failureCode = this.checker.getFailureCode();
		this.decisionResult.failureMessage = this.checker.getFailureExplanation();
	}
	
	
	
	private void executeDecisionActions(List<DeciAction<T>> decisionActions) {
		if (decisionActions == null)
			return;
			
		for (DeciAction<T> eachAction : decisionActions) {
			eachAction.executeAction();
			DeciResult<T> actionResult = eachAction.getDecisionResult();		
			buildResultFromAction(actionResult);
			
			if (actionResult.hasSuccessfullyFinished() == RESULT_FAILED)
				break;
		}
	}
	
	
	
	private void buildResultFromAction(DeciResult<T> decisionActionResult) {
		this.decisionResult.finishedWithSuccess = decisionActionResult.hasSuccessfullyFinished();
		if (this.decisionResult.finishedWithSuccess == RESULT_FAILED) {
			this.decisionResult.failureCode = decisionActionResult.getFailureCode();
			this.decisionResult.failureMessage = decisionActionResult.getFailureMessage();
		}
		
		
		this.decisionResult.hasResultset = decisionActionResult.hasResultset();
		if (decisionActionResult.hasResultset()) {
			this.decisionResult.resultset = decisionActionResult.getResultset();
		}
		
		
		if (this.decisionResult.hasResultset()) {
			if (this.decisionResult.resultset == null || this.decisionResult.resultset.isEmpty()) {
				this.decisionResult.finishedWithSuccess = RESULT_FAILED;
				this.decisionResult.failureCode = Response.Status.BAD_REQUEST.getStatusCode();
				this.decisionResult.failureMessage = SystemMessage.DATA_NOT_FOUND;
			}
		}
	}
	
	
	
	public DeciChoice getDecisionMade() {
		return this.decisionChoice;
	}


	
	public DeciResult<T> getDecisionResult() {
		return this.decisionResult;
	}
	
	
	
	@Override public DeciAction<T> getAsAction() {
		return new DeciTreeAdapter<>(this);
	}
}
