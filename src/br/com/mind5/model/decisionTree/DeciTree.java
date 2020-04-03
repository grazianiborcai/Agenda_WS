package br.com.mind5.model.decisionTree;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV1;

public interface DeciTree<T extends InfoRecord> {
	public void makeDecision();
	
	public DeciResult<T> getDecisionResult();
	
	public ActionStdV1<T> toAction();
	
	public void close();
}
