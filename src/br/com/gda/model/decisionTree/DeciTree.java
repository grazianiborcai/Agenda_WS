package br.com.gda.model.decisionTree;

import br.com.gda.model.action.ActionStd;

public interface DeciTree<T> {
	public void makeDecision();
	
	public DeciResult<T> getDecisionResult();
	
	public ActionStd<T> toAction();
}
