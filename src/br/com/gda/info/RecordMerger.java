package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class RecordMerger<T,K,S> {
	protected List<T> merge(List<K> sourceOnes, List<S> sourceTwos, VisitorMerger<T,K,S> visitor) {
		checkArgument(sourceOnes, sourceTwos);
		
		List<T> results = new ArrayList<>();
		
		for (K eachSourceOne : sourceOnes) {			
			for (S eachSourceTwo : sourceTwos) {
				T oneResult = merge(eachSourceOne, eachSourceTwo, visitor);
				results.add(oneResult);
			}
		}			
			
		return results;
	}
	
	
	
	private void checkArgument(List<K> sourceOnes, List<S> sourceTwos) {
		if (sourceOnes == null)
			throw new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwos == null)
			throw new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	protected T merge(K sourceOne, S sourceTwo, VisitorMerger<T,K,S> visitor) {
		checkArgument(sourceOne, sourceTwo, visitor);
		return visitor.mergeRecord(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(K sourceOne, S sourceTwo, VisitorMerger<T,K,S> visitor) {
		if (sourceOne == null)
			throw new NullPointerException("sourceOne" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo == null)
			throw new NullPointerException("sourceTwo" + SystemMessage.NULL_ARGUMENT);
		
		if (visitor == null)
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
	}
}
