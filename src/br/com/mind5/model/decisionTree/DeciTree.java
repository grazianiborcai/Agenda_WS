package br.com.mind5.model.decisionTree;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV2;

public interface DeciTree<T extends InfoRecord> {
	public void makeDecision();
	
	public DeciResult<T> getDecisionResult();
	
	public ActionStdV2<T> toAction();
	
	public void close();
}
