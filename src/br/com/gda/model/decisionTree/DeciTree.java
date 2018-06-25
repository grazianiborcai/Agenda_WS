package br.com.gda.model.decisionTree;

public interface DeciTree<T> {
	public void makeDecision();
	
	public DeciChoice getDecisionMade();	
	
	public DeciResult<T> getDecisionResult();
	
	public DeciAction<T> toAction();
}
