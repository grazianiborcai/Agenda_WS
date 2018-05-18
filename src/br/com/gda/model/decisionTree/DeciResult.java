package br.com.gda.model.decisionTree;

import java.util.List;

public interface DeciResult<T> {
	public boolean hasSuccessfullyFinished();	
	
	public String getFailureMessage();
	
	public int getFailureCode();
	
	public boolean hasResultset();
	
	public List<T> getResultset();
}
