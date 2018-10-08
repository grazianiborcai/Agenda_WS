package br.com.gda.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;


public abstract class ActionVisitorTemplateEnforce<T extends InfoRecord> implements ActionVisitor<T> {	
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		List<T> resultRecords = new ArrayList<>();		
		
		for (T eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}
	
	
	
	private T enforce(T recordInfo) {
		T clonedInfo = makeClone(recordInfo);
		return enforceHook(clonedInfo);
	}
	
	
	
	protected T enforceHook(T recordInfo) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
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
