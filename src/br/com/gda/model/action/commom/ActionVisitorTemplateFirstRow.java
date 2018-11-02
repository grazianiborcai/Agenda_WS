package br.com.gda.model.action.commom;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.info.InfoRecord;
import br.com.gda.model.action.ActionVisitorEnforce;


public abstract class ActionVisitorTemplateFirstRow<T extends InfoRecord> implements ActionVisitorEnforce<T> {
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		List<T> resultRecords = new ArrayList<>();		
		
		resultRecords.add(makeClone(recordInfos.get(0)));		
		
		return resultRecords;
	}	
	
	
	
	@SuppressWarnings("unchecked")
	private T makeClone(T recordInfo) {
		try {
			return (T) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
