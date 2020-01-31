package br.com.mind5.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public abstract class InfoMergerTemplateV2<T extends InfoRecord, K extends InfoRecord> implements InfoMerger<T, K> {	
	
	@Override public List<T> merge(List<K> selectedInfos, List<T> baseInfos) {
		checkArgument(selectedInfos, baseInfos);
		
		List<K> selecteds = makeClone(selectedInfos);
		List<T> bases = makeClone(baseInfos);
		
		return write(selecteds, bases);
	}
	
	
	
	@Override public T merge(K selectedInfo, T baseInfo) {
		checkArgument(selectedInfo, baseInfo);
		
		K selected = makeClone(selectedInfo);
		T base = makeClone(baseInfo);
		
		return write(selected, base);
	}	


	
	private List<T> write(List<K> selectedInfos, List<T> baseInfos) {
		if (isEmpty(selectedInfos, baseInfos))
			return baseInfos;		
		
		baseInfos = beforeWriteHook(baseInfos);		
		List<T> results = new ArrayList<>();
		
		for (T eachBase : baseInfos) {
			boolean flagMerge = false;
			
			for (K eachSelected : selectedInfos) {
				if (shouldWriteHook(eachSelected, eachBase)) {
					T oneResult = write(eachSelected, eachBase);
					
					results.add(oneResult);
					flagMerge = true;
				}
			}
			
			if (flagMerge == false)
				results.add(eachBase);
		}
		
		
		checkResults(results);		
		return uniquifyHook(results);
	}
	
	
	
	private T write(K selectedInfo, T baseInfo) {
		checkArgument(selectedInfo, baseInfo);
		
		T result = writeHook(selectedInfo, baseInfo);
		checkResult(result);
		
		return result;
	}
	
	
	
	protected List<T> beforeWriteHook(List<T> baseInfos) {
		//Template method: default behavior
		return baseInfos;
	}
	
	
	
	protected T writeHook(K selectedInfo, T baseInfo) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected boolean shouldWriteHook(K selectedInfo, T baseInfo) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected List<T> uniquifyHook(List<T> results) {
		//Template method: default behavior
		return results.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private boolean isEmpty(List<?> selectedInfos, List<?> baseInfos) {
		if (selectedInfos.isEmpty() || baseInfos.isEmpty())
			return true;
		
		return false;
	}
	
	
	
	private void checkArgument(List<K> selectedInfos, List<T> baseInfos) {
		if (selectedInfos == null) {
			logException(new NullPointerException("selectedInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("selectedInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (baseInfos == null) {
			logException(new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT);	
		}
	}
	
	
	
	private void checkArgument(K selectedInfo, T baseInfo) {
		if (selectedInfo == null) {
			logException(new NullPointerException("selectedInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("selectedInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (baseInfo == null) {
			logException(new NullPointerException("baseInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("baseInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkResult(T result) {
		if (result == null) {
			logException(new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL));
			throw new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL);
		}
	}
	
	
	
	private void checkResults(List<T> results) {
		if (results == null || results.isEmpty()) {
			logException(new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL));
			throw new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL);
		}
	}
	
	
	
	private <Y extends InfoRecord> List<Y> makeClone(List<Y> recordInfos) {
		List<Y> results = new ArrayList<>();
		
		for (Y eachRecord: recordInfos) {
			Y clonedInfo = makeClone(eachRecord);
			results.add(clonedInfo);
		}
		
		return results;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private <Y extends InfoRecord> Y makeClone(Y recordInfo) {
		try {
			return (Y) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
