package br.com.mind5.model.decisionTree;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface DeciResult<T extends InfoRecord> {
	public boolean isSuccess();	
	
	public String getFailMessage();
	
	public int getFailCode();
	
	public boolean hasResultset();
	
	public List<T> getResultset();
}
