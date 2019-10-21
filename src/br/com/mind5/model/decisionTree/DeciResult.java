package br.com.mind5.model.decisionTree;

import java.util.List;

public interface DeciResult<T> {
	public boolean isSuccess();	
	
	public String getFailMessage();
	
	public int getFailCode();
	
	public boolean hasResultset();
	
	public List<T> getResultset();
}
