package br.com.gda.model.decisionTree;

import java.util.List;

public interface DeciActionHandler<T> {
	public boolean executeAction(List<T> infoRecords);
	
	public boolean executeAction(T infoRecord);
	
	public DeciResult<T> getDecisionResult(); 
}
