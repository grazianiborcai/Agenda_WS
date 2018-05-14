package br.com.gda.model.decisionTree;

public interface DecisionAction<T> {
	public boolean executeAction();
	
	public DecisionResult<T> getDecisionResult();
}
