package br.com.mind5.info;

import java.util.List;

public abstract class InfoMergerVisitorTemplate<T extends InfoRecord, K extends InfoRecord> implements InfoMergerVisitor<T, K> {
	
	@Override public List<T> beforeMerge(List<T> baseInfos) {
		return beforeMergeHook(baseInfos);
	}
	
	
	
	@Override public InfoUniquifier<T> getUniquifier() {
		return getUniquifierHook();
	}
	
	
	
	@Override public InfoMergerCardinality getCardinality() {
		return getCardinalityHook();
	}
	
	
	
	protected List<T> beforeMergeHook(List<T> baseInfos) {
		//Template Method: Default behavior
		return baseInfos;
	}
	
	
	
	protected InfoUniquifier<T> getUniquifierHook() {
		return null;
	}
	
	
	
	protected InfoMergerCardinality getCardinalityHook() {
		//Template Method: Default behavior
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
