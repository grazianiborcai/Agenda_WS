package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class InfoMerger<T,K,S> {
	protected List<T> merge(List<K> sourceOnes, List<S> sourceTwos, InfoMergerVisitor<T,K,S> visitor) {
		checkArgument(sourceOnes, sourceTwos);
		
		List<T> results = new ArrayList<>();
		
		for (K eachSourceOne : sourceOnes) {			
			for (S eachSourceTwo : sourceTwos) {
				T oneResult = tryToMerge(eachSourceOne, eachSourceTwo, visitor);
				
				if (oneResult != null)
					results.add(oneResult);
			}
		}			
			
		return results;
	}
	
	
	
	private T tryToMerge(K sourceOne, S sourceTwo, InfoMergerVisitor<T,K,S> visitor) {
		try {
			return merge(sourceOne, sourceTwo, visitor);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	private void checkArgument(List<K> sourceOnes, List<S> sourceTwos) {
		if (sourceOnes == null)
			throw new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwos == null)
			throw new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT);		
		
		if (sourceOnes.isEmpty())
			throw new IllegalArgumentException("sourceOnes" + SystemMessage.EMPTY_ARGUMENT);
		
		if (sourceTwos.isEmpty())
			throw new IllegalArgumentException("sourceTwos" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	
	protected T merge(K sourceOne, S sourceTwo, InfoMergerVisitor<T,K,S> visitor) {
		checkArgument(sourceOne, sourceTwo, visitor);
		return visitor.mergeRecord(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(K sourceOne, S sourceTwo, InfoMergerVisitor<T,K,S> visitor) {
		if (sourceOne == null)
			throw new NullPointerException("sourceOne" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo == null)
			throw new NullPointerException("sourceTwo" + SystemMessage.NULL_ARGUMENT);
		
		if (visitor == null)
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
	}
}
