package br.com.mind5.model.action;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionStdV1<T extends InfoRecord> {
	public boolean executeAction();
	
	public DeciResult<T> getDecisionResult();
	
	public void addPostAction(ActionLazy<T> actionLazy);
}
