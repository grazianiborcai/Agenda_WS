package br.com.gda.model.decisionTree;

public interface DecisionActionAdapter<T> {
	public boolean executeAction();
	
	public DecisionResult<T> getDecisionResult();
}
