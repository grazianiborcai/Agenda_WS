package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionMultiVisitor<T> {
	public boolean executeAction(List<List<T>> infoRecords);
	
	public DeciResult<T> getDecisionResult(); 
}
