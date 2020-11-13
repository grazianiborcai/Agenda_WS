package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionLazy<T extends InfoRecord> { 
	public boolean executeAction(List<T> infoRecords);
	
	public boolean executeAction(T infoRecord);
	
	public DeciResult<T> getDecisionResult(); 	
	
	public ActionStd<T> toAction(List<T> recordInfos);
	
	public void addPostAction(ActionLazy<T> actionHandler);
	
	public void close();
}
