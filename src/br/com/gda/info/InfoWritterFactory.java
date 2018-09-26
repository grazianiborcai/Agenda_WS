package br.com.gda.info;

import java.util.Collections;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class InfoWritterFactory<T> {
	private InfoUniquifier<T> resultUniquifier;
	
	
	protected InfoWritterFactory() {	
		resultUniquifier = null;
	}
	
	
	protected InfoWritterFactory(InfoUniquifier<T> uniquifier) {
		checkArgument(uniquifier);
		
		resultUniquifier = uniquifier;
	}
	
	
	
	private void checkArgument(InfoUniquifier<T> uniquifier) {
		if (uniquifier == null)
			throw new NullPointerException("uniquifier" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	public List<T> merge(List<?> sourceOnes, List<?> sourceTwos) {
		checkArgument(sourceOnes, sourceTwos);
		
		if (isEmpty(sourceOnes, sourceTwos))
			return Collections.emptyList();
		
		List<T> results = writeHook(sourceOnes, sourceTwos);
		
		if (results == null || results.isEmpty()) 
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_POSSIBLE);		
		
		
		if (resultUniquifier == null)
			return results;
		
		return resultUniquifier.uniquify(results);
	} 
	
	
	
	public List<T> prune(List<?> sourceOnes, List<?> sourceTwos) {
		checkArgument(sourceOnes, sourceTwos);
		
		if (isEmpty(sourceOnes, sourceTwos))
			return Collections.emptyList();
		
		List<T> results = writeHook(sourceOnes, sourceTwos);
		
		if (results == null) 
			return Collections.emptyList();		
		
		
		if (resultUniquifier == null)
			return results;
		
		return resultUniquifier.uniquify(results);
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
	
	
	
	protected List<T> writeHook(List<?> sourceOnes, List<?> sourceTwos) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
}
