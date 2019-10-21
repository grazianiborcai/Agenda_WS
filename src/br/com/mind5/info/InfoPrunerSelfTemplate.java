package br.com.mind5.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public abstract class InfoPrunerSelfTemplate<T extends InfoRecord> implements InfoPrunerSelf<T> {
	
	@Override public List<T> prune(List<T> sources) {
		checkArgument(sources);
		
		if (isEmpty(sources))
			return Collections.emptyList();
		
		InfoPrunerSelfVisitor<T> visitor = getVisitorHook();		
		return pruneWithVisitor(sources, visitor);
	}
	
	
	
	private boolean isEmpty(List<T> source) {
		if (source.isEmpty())
			return true;
		
		return false;
	}
	
	
	
	protected InfoPrunerSelfVisitor<T> getVisitorHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<T> pruneWithVisitor(List<T> sources, InfoPrunerSelfVisitor<T> visitor) {
		List<T> results = new ArrayList<>();				
		
		for (T eachSource : sources) {	
			T oneResult = tryToPrune(eachSource, visitor);
			
			if (oneResult != null)
				results.add(oneResult);
		}			
		
		return results;
	}
	
	
	
	private T tryToPrune(T sources, InfoPrunerSelfVisitor<T> visitor) {
		try {
			return prune(sources, visitor);
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private T prune(T source, InfoPrunerSelfVisitor<T> visitor) {
		checkArgument(source, visitor);
		return visitor.pruneRecord(source);
	}
	
	
	
	private void checkArgument(List<T> source) {
		if (source == null) {
			logException(new NullPointerException("source" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("source" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(T source, InfoPrunerSelfVisitor<T> visitor) {
		if (source == null) {
			logException(new NullPointerException("source" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("source" + SystemMessage.NULL_ARGUMENT);
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
