package br.com.gda.model.action;

import java.util.List;

import br.com.gda.model.decisionTree.DeciResult;

public interface ActionDual<T> {
	public boolean executeAction(List<T> infoOnes, List<T> infoTwos);
	
	public boolean executeAction(T infoOne, T infoTwo);
	
	public DeciResult<T> getDecisionResult();
	
	public void addPostAction(ActionLazy<T> actionHandler);
}
