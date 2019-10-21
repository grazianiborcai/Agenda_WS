package br.com.mind5.model.action;

import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionStd<T> {
	public boolean executeAction();
	
	public DeciResult<T> getDecisionResult();
	
	public void addPostAction(ActionLazy<T> actionHandler);
}
