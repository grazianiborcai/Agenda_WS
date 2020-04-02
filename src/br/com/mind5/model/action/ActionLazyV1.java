package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionLazyV1<T extends InfoRecord> {
	//TODO: adicionar classe que chamou como parametro ?
	public boolean executeAction(List<T> infoRecords);
	
	public boolean executeAction(T infoRecord);
	
	public DeciResult<T> getDecisionResult(); 	
	
	public ActionStdV1<T> toAction(List<T> recordInfos);
	
	public void addPostAction(ActionLazyV1<T> actionHandler);
}
