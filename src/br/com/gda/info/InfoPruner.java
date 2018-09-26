package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class InfoPruner<T,S> {
	protected List<T> prune(List<T> sourceOnes, List<S> sourceTwos, InfoPrunerVisitor<T,S> visitor) {
		checkArgument(sourceOnes, sourceTwos);
		List<T> results = new ArrayList<>();
		T oneResult = null;
		
		
		for (T eachSourceOne : sourceOnes) {	
			for (S eachSourceTwo : sourceTwos) {				
				if (oneResult == null) {
					oneResult = tryToPrune(eachSourceOne, eachSourceTwo, visitor);
				} else {
					oneResult = tryToPrune(oneResult, eachSourceTwo, visitor);
				}
				
				if (oneResult == null)
					break;
			}
			
			if (oneResult != null)
				results.add(oneResult);
		}	
		
		
		return results;
	}
	
	
	
	private T tryToPrune(T sourceOne, S sourceTwo, InfoPrunerVisitor<T,S> visitor) {
		try {
			return prune(sourceOne, sourceTwo, visitor);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	private void checkArgument(List<T> sourceOnes, List<S> sourceTwos) {
		if (sourceOnes == null)
			throw new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwos == null)
			throw new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT);		
		
		if (sourceOnes.isEmpty())
			throw new IllegalArgumentException("sourceOnes" + SystemMessage.EMPTY_ARGUMENT);
		
		if (sourceTwos.isEmpty())
			throw new IllegalArgumentException("sourceTwos" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	
	protected T prune(T sourceOne, S sourceTwo, InfoPrunerVisitor<T,S> visitor) {
		checkArgument(sourceOne, sourceTwo, visitor);
		return visitor.pruneRecord(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(T sourceOne, S sourceTwo, InfoPrunerVisitor<T,S> visitor) {
		if (sourceOne == null)
			throw new NullPointerException("sourceOne" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo == null)
			throw new NullPointerException("sourceTwo" + SystemMessage.NULL_ARGUMENT);
		
		if (visitor == null)
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
	}
}
