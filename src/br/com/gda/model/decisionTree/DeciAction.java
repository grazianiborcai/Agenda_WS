package br.com.gda.model.decisionTree;

public interface DeciAction<T> {
	public boolean executeAction();
	
	public DeciResult<T> getDecisionResult();
	
	public void addPostAction(DeciActionHandler<T> actionHandler);
}
