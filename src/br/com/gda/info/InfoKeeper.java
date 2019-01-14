package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public abstract class InfoKeeper<T,S> {
	protected List<T> write(List<T> sourceOnes, List<S> sourceTwos, InfoKeeperVisitor<T,S> visitor) {
		checkArgument(sourceOnes, sourceTwos);
		List<T> results = new ArrayList<>();
		T oneResult = null;
		
		
		for (T eachSourceOne : sourceOnes) {	
			oneResult = null;
			
			for (S eachSourceTwo : sourceTwos) {	
				T writeOne = eachSourceOne;
				S writeTwo = eachSourceTwo;
				
				if (oneResult != null) 
					writeOne = oneResult;
				
				if (visitor.shouldWrite(writeOne, writeTwo)) {
					oneResult = tryToWrite(writeOne, writeTwo, visitor);
					
					if (oneResult == null)
						break;
				}
			}
			
			
			if (oneResult != null)
				results.add(oneResult);
		}	
		
		
		return results;
	}
	
	
	
	private T tryToWrite(T sourceOne, S sourceTwo, InfoKeeperVisitor<T,S> visitor) {
		try {
			return write(sourceOne, sourceTwo, visitor);
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private void checkArgument(List<T> sourceOnes, List<S> sourceTwos) {
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
	
	
	
	protected T write(T sourceOne, S sourceTwo, InfoKeeperVisitor<T,S> visitor) {
		checkArgument(sourceOne, sourceTwo, visitor);
		return visitor.keepAtribute(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(T sourceOne, S sourceTwo, InfoKeeperVisitor<T,S> visitor) {
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
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
