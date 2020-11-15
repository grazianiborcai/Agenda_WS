package br.com.mind5.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public final class InfoMergerHelper<T extends InfoRecord, K extends InfoRecord> implements InfoMerger<T, K> {	
	private final List<T> bases; 
	private final List<K> seles;	
	private final InfoMergerVisitor<T,K> merger;
	private final Class<?> mergerClazz;
	
	
	public InfoMergerHelper (List<T> baseInfos, List<K> selectedInfos, InfoMergerVisitor<T, K> visitor) {
		checkArgument(baseInfos, selectedInfos, visitor);
		
		bases = InfoUtil.copy(baseInfos);
		seles = InfoUtil.copy(selectedInfos);		
		mergerClazz = visitor.getClass();
		merger = visitor;
	}
	
	
	
	@Override public List<T> merge() {		
		if (isEmpty(bases, seles))
			return bases;	
		
		List<T> baseInfos = InfoUtil.copy(bases); 
		List<K> selectedInfos = InfoUtil.copy(seles);
		
		return mergeWithVisitor(baseInfos, selectedInfos, merger);
	}


	
	private List<T> mergeWithVisitor(List<T> baseInfos, List<K> selectedInfos, InfoMergerVisitor<T,K> visitor) {
		baseInfos = visitor.beforeMerge(baseInfos);		
		List<T> results = new ArrayList<>();
		
		
		for (T eachBase : baseInfos) {
			boolean flagMerge = false;
			
			for (K eachSelected : selectedInfos) {
				if (visitor.shouldMerge(eachBase, eachSelected)) {
					List<T> eachResults = visitor.merge(eachBase, eachSelected);
					
					checkResults(eachResults);
					results.addAll(eachResults);
					flagMerge = true;
				}
			}
			
			if (flagMerge == false)
				results.add(eachBase);
		}
		
		
		checkResults(results);		
		return uniquify(results, visitor);
	}
	
	
	
	private List<T> uniquify(List<T> results, InfoMergerVisitor<T,K> visitor) {
		InfoUniquifier<T> uniquifier = visitor.getUniquifier();
		
		if (uniquifier == null)
			return results.stream().distinct().collect(Collectors.toList());
		
		return uniquifier.uniquify(results);		
	}
	
	
	
	private boolean isEmpty(List<?> selectedInfos, List<?> baseInfos) {
		if (selectedInfos.isEmpty() || baseInfos.isEmpty())
			return true;
		
		return false;
	}
	
	
	
	private void checkResults(List<T> results) {
		if (results == null || results.isEmpty()) {
			logException(new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL));
			throw new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL);
		}
		
		
		for (T eachResult : results) {
			if (eachResult == null) {
				logException(new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL));
				throw new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL);
			}
		}
	}
	
	
	
	private void checkArgument(List<T> baseInfos, List<K> selectedInfos, InfoMergerVisitor<T, K> visitor) {
		if (baseInfos == null) {
			logException(new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (selectedInfos == null) {
			logException(new NullPointerException("selectedInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("selectedInfos" + SystemMessage.NULL_ARGUMENT);		
		}
		
		
		if (baseInfos.isEmpty()) {
			logException(new IllegalArgumentException("baseInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("baseInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Class<?> clazz = mergerClazz;
		
		if (clazz == null)
			clazz = this.getClass();
		
		SystemLog.logError(clazz, e);
	}
}