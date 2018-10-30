package br.com.gda.model.decisionTree;

import java.util.List;

public interface DeciResult<T> {
	public boolean isSuccess();	
	
	public String getFailMessage();
	
	public int getFailCode();
	
	public boolean hasResultset();
	
	public List<T> getResultset();
}
