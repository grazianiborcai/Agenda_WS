package br.com.mind5.model.action.obsolete;

import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionMultiVisitor<T extends InfoRecord> {
	public boolean executeAction(List<List<T>> infoRecords);
	
	public DeciResult<T> getDecisionResult(); 
}
