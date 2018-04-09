package br.com.gda.model.decisionTree;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelChecker;

public final class DecisionTreeHelper<T> implements DecisionTree<T> {
	private T recordInfo;
	private ModelChecker<T> checker;
	private DecisionResult decisionResult;

	public DecisionTreeHelper(DecisionTreeOption<T> option) {
		if (option == null)
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (option.visitorChecker == null)
			throw new NullPointerException("option.visitorCheckerStack" + SystemMessage.NULL_ARGUMENT);
		
		if (option.recordInfo == null)
			throw new NullPointerException("option.recordInfo" + SystemMessage.NULL_ARGUMENT);
		
		
		this.checker = option.visitorChecker;
		this.recordInfo = option.recordInfo;
		this.decisionResult = null;
		
		makeDecision();
	}
	
	
	
	private void makeDecision() {
		boolean RESULT_SUCCESS = true;
		boolean RESULT_FAILED = false;
		
		boolean checkResult = check();
		
		if (checkResult == RESULT_SUCCESS)
			onPassed();
		
		if (checkResult == RESULT_FAILED)
			onFailed();
	}
	
	
	
	private boolean check() {		
		return this.checker.check(this.recordInfo);
	}
	
	
	
	private void onPassed() {
		this.decisionResult = DecisionResult.PASSED;
	}
	
	
	
	private void onFailed() {
		this.decisionResult = DecisionResult.FAILED;
		
	}
	
	
	
	public DecisionResult getDecision() {
		return this.decisionResult;
	}
}
