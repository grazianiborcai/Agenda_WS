package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class InfoWriter<T,K,S> {
	protected List<T> write(List<K> sourceOnes, List<S> sourceTwos, InfoWriteVisitor<T,K,S> visitor) {
		checkArgument(sourceOnes, sourceTwos);
		
		List<T> results = new ArrayList<>();
		
		for (K eachSourceOne : sourceOnes) {			
			for (S eachSourceTwo : sourceTwos) {
				T oneResult = tryToWrite(eachSourceOne, eachSourceTwo, visitor);
				
				if (oneResult != null)
					results.add(oneResult);
			}
		}			
			
		return results;
	}
	
	
	
	private T tryToWrite(K sourceOne, S sourceTwo, InfoWriteVisitor<T,K,S> visitor) {
		try {
			return write(sourceOne, sourceTwo, visitor);
			
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
	
	
	
	protected T write(K sourceOne, S sourceTwo, InfoWriteVisitor<T,K,S> visitor) {
		checkArgument(sourceOne, sourceTwo, visitor);
		return visitor.writeRecord(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(K sourceOne, S sourceTwo, InfoWriteVisitor<T,K,S> visitor) {
		if (sourceOne == null)
			throw new NullPointerException("sourceOne" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo == null)
			throw new NullPointerException("sourceTwo" + SystemMessage.NULL_ARGUMENT);
		
		if (visitor == null)
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
	}
}
