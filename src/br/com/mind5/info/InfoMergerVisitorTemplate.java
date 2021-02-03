package br.com.mind5.info;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class InfoMergerVisitorTemplate<T extends InfoRecord, K extends InfoRecord> implements InfoMergerVisitor<T, K> {
	
	@Override public List<T> beforeMerge(List<T> baseInfos) {
		return beforeMergeHook(baseInfos);
	}
	
	
	
	@Override public List<T> uniquify(List<T> results) {
		return uniquifyHook(results);
	}
	
	
	
	@Override public InfoMergerCardinality getCardinality() {
		return getCardinalityHook();
	}
	
	
	
	@Override public List<T> afterMerge(List<T> results) {
		return afterMergeHook(results);
	}
	
	
	
	protected List<T> beforeMergeHook(List<T> baseInfos) {
		//Template Method: Default behavior
		return baseInfos;
	}
	
	
	
	protected List<T> uniquifyHook(List<T> results) {
		return results.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	protected InfoMergerCardinality getCardinalityHook() {
		//Template Method: Default behavior
		return InfoMergerCardinality.ONE_TO_ONE;
	}
	
	
	
	protected List<T> afterMergeHook(List<T> results) {
		//Template Method: Default behavior
		return results;
	}
	

	
	protected <S extends Comparable<? super S>> List<S> sortAscending(List<S> results) {
		if(shouldSort(results) == false)
			return results;
		
		Collections.sort(results);
		return results;
	}
	
	
	
	private boolean shouldSort(List<?> results) {
		if(results == null)
			return false;
		
		if(results.isEmpty())
			return false;
		
		return true;
	}
}
