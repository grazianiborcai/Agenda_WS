package br.com.gda.model.action;

import br.com.gda.model.decisionTree.DeciResult;

public interface ActionStd<T> {
	public boolean executeAction();
	
	public DeciResult<T> getDecisionResult();
	
	public void addPostAction(ActionLazy<T> actionHandler);
}
