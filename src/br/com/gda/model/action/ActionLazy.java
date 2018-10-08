package br.com.gda.model.action;

import java.util.List;

import br.com.gda.model.decisionTree.DeciResult;

public interface ActionLazy<T> {
	public boolean executeAction(List<T> infoRecords);
	
	public boolean executeAction(T infoRecord);
	
	public DeciResult<T> getDecisionResult(); 	
	
	public ActionStd<T> toAction(List<T> recordInfos);
	
	public void addPostAction(ActionLazy<T> actionHandler);
}
