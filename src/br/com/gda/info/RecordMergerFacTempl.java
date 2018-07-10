package br.com.gda.info;

import java.util.Collections;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class RecordMergerFacTempl<T> {
	
	public List<T> merge(List<?> sourceOnes, List<?> sourceTwos) {
		checkArgument(sourceOnes, sourceTwos);
		
		if (isEmpty(sourceOnes, sourceTwos))
			return Collections.emptyList();
		
		List<T> result = mergeHook(sourceOnes, sourceTwos);
		
		if (result == null || result.isEmpty()) 
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_POSSIBLE);		
		
		return result;
	} 
	
	
	
	private void checkArgument(List<?> sourceOnes, List<?> sourceTwos) {
		if (sourceOnes == null)
			throw new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwos == null)
			throw new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private boolean isEmpty(List<?> sourceOnes, List<?> sourceTwos) {
		if (sourceOnes.isEmpty() || sourceTwos.isEmpty())
			return true;
		
		return false;
	}
	
	
	
	protected List<T> mergeHook(List<?> sourceOnes, List<?> sourceTwos) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
}
