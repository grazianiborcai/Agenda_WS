package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public abstract class InfoMerger_<T  extends InfoRecord, K extends InfoRecord, S extends InfoRecord> {
	
	protected List<T> write(List<K> sourceOnes, List<S> sourceTwos, InfoMergerVisitor<T,K,S> visitor) {
		checkArgument(sourceOnes, sourceTwos);		
		List<T> results = new ArrayList<>();
		
		for (K eachSourceOne : sourceOnes) {			
			for (S eachSourceTwo : sourceTwos) {				
				if (visitor.shouldWrite(eachSourceOne, eachSourceTwo)) {
					T oneResult = tryToWrite(eachSourceOne, eachSourceTwo, visitor);
					
					checkResult(oneResult);
					results.add(oneResult);
				}
			}
		}			
			
		return results;
	}
	
	
	
	private void checkArgument(List<K> sourceOnes, List<S> sourceTwos) {
		if (sourceOnes == null) {
			logException(new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sourceTwos == null) {
			logException(new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT);	
		}
		
		
		if (sourceOnes.isEmpty()) {
			logException(new IllegalArgumentException("sourceOnes" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("sourceOnes" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		if (sourceTwos.isEmpty()) {
			logException(new IllegalArgumentException("sourceTwos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("sourceTwos" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private T tryToWrite(K sourceOne, S sourceTwo, InfoMergerVisitor<T,K,S> visitor) {
		try {
			return write(sourceOne, sourceTwo, visitor);
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(SystemMessage.MERGE_NOT_POSSIBLE);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	protected T write(K sourceOne, S sourceTwo, InfoMergerVisitor<T,K,S> visitor) {
		checkArgument(sourceOne, sourceTwo, visitor);
		
		K clonedSourceOne = (K) makeClone(sourceOne);

		return visitor.writeRecord(clonedSourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(K sourceOne, S sourceTwo, InfoMergerVisitor<T,K,S> visitor) {
		if (sourceOne == null) {
			logException(new NullPointerException("sourceOne" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceOne" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sourceTwo == null) {
			logException(new NullPointerException("sourceTwo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceTwo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkResult(T result) {
		if (result == null) {
			logException(new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL));
			throw new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL);
		}
	}
	
	
	
	private InfoRecord makeClone(InfoRecord recordInfo) {
		try {
			return (InfoRecord) recordInfo.clone();
			
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
