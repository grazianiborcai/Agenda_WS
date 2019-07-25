package br.com.gda.model.action.commom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;
import br.com.gda.model.action.ActionVisitorEnforce;


public abstract class ActionVisitorTemplateFirstRow<T extends InfoRecord> implements ActionVisitorEnforce<T> {
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		List<T> sortedList = sortList(recordInfos);	
		return getFirstRow(sortedList);
	}
	
	
	
	private List<T> sortList(List<T> recordInfos) {
		Comparator<T> comparator = getComparatorHook();		
		checkArgument(comparator);		
		
		return tryToSortList(recordInfos, comparator);		
	}
	
	
	
	protected Comparator<T> getComparatorHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<T> tryToSortList(List<T> recordInfos, Comparator<T> compator) {
		try {
			Collections.sort(recordInfos, compator); 
			return recordInfos;
		
		} catch (Exception e) {
			logException(new IllegalArgumentException(e));
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	private List<T> getFirstRow(List<T> recordInfos) {
		List<T> results = new ArrayList<>();
		
		T firstRow = makeClone(recordInfos.get(0));	
		results.add(firstRow);
		
		return results;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private T makeClone(T recordInfo) {
		try {
			return (T) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private void checkArgument(Comparator<T> compator) {
		if (compator == null) {
			logException(new NullPointerException("Compator" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("Compator" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
