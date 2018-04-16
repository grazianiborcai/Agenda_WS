package br.com.gda.model.decisionTree;

public interface DecisionTree<T> {
	public void makeDecision();
	
	public DecisionChoice getDecisionMade();	
	
	public DecisionResult<T> getDecisionResult();
}
