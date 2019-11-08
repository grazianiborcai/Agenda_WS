package br.com.mind5.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public abstract class InfoMergerTemplate<T extends InfoRecord, K extends InfoRecord> implements InfoMerger<T, K> {	
	
	@Override public List<T> merge(List<K> sourceOnes, List<T> sourceTwos) {
		InfoMergerVisitor<T,K> visitor = getVisitorHook();
		return write(sourceOnes, sourceTwos, visitor);
	}
	
	
	
	@Override public T merge(K sourceOne, T sourceTwo) {
		InfoMergerVisitor<T,K> visitor = getVisitorHook();
		return write(sourceOne, sourceTwo, visitor);
	}
	
	
	
	protected InfoMergerVisitor<T,K> getVisitorHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<T> write(List<K> sourceOnes, List<T> sourceTwos, InfoMergerVisitor<T,K> visitor) {
		checkArgument(sourceOnes, sourceTwos);		
		
		if (isEmpty(sourceOnes, sourceTwos))
			return sourceTwos;
		
		List<T> results = new ArrayList<>();
		
		for (T eachSourceTwo : sourceTwos) {
			boolean flagMerge = false;
			
			for (K eachSourceOne : sourceOnes) {
				if (visitor.shouldWrite(eachSourceOne, eachSourceTwo)) {
					T oneResult = write(eachSourceOne, eachSourceTwo, visitor);
					
					checkEachResult(oneResult);
					results.add(oneResult);
					flagMerge = true;
				}
			}
			
			if (flagMerge == false)
				results.add(eachSourceTwo);
		}
		
		checkResults(results);
		return uniquifyResults(results);
	}
	
	
	
	private boolean isEmpty(List<?> sourceOnes, List<?> sourceTwos) {
		if (sourceOnes.isEmpty() || sourceTwos.isEmpty())
			return true;
		
		return false;
	}

	
	
	private T write(K sourceOne, T sourceTwo, InfoMergerVisitor<T,K> visitor) {
		try {
			return tryTowrite(sourceOne, sourceTwo, visitor);
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(SystemMessage.MERGE_NOT_POSSIBLE);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	private T tryTowrite(K sourceOne, T sourceTwo, InfoMergerVisitor<T,K> visitor) {
		checkArgument(sourceOne, sourceTwo, visitor);
		
		K clonedSourceOne = (K) makeClone(sourceOne);

		return visitor.writeRecord(clonedSourceOne, sourceTwo);
	}
	
	
	
	private List<T> uniquifyResults(List<T> results) {
		InfoUniquifier<T> uniquifier = getUniquifierHook();
		
		if (uniquifier == null)
			return results;		

		return uniquifier.uniquify(results);
	}
	
	
	
	protected InfoUniquifier<T> getUniquifierHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	private void checkArgument(List<K> sourceOnes, List<T> sourceTwos) {
		if (sourceOnes == null) {
			logException(new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceOnes" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sourceTwos == null) {
			logException(new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceTwos" + SystemMessage.NULL_ARGUMENT);	
		}
	}
	
	
	
	private void checkArgument(K sourceOne, T sourceTwo, InfoMergerVisitor<T,K> visitor) {
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
	
	
	
	private void checkEachResult(T result) {
		if (result == null) {
			logException(new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL));
			throw new IllegalArgumentException(SystemMessage.MERGE_RETURNED_NULL);
		}
	}
	
	
	
	private void checkResults(List<T> results) {
		if (results == null || results.isEmpty()) {
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
