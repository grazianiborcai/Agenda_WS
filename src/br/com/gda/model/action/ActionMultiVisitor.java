package br.com.gda.model.action;

import java.util.List;

import br.com.gda.model.decisionTree.DeciResult;

public interface ActionMultiVisitor<T> {
	public boolean executeAction(List<List<T>> infoRecords);
	
	public DeciResult<T> getDecisionResult(); 
}
