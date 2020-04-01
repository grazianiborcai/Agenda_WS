package br.com.mind5.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public class InfoCopierOneToManyTemplate<T extends InfoRecord, S extends InfoRecord> implements InfoCopierOneToMany<T,S> {
	private InfoUniquifier<T> resultUniquifier;
	
	
	public InfoCopierOneToManyTemplate() {
		resultUniquifier = null;
	}
	
	
	
	public InfoCopierOneToManyTemplate(InfoUniquifier<T> uniquifier) {
		checkArgument(uniquifier);
		resultUniquifier = uniquifier;
	}
	
	
	
	public List<T> makeCopy(List<S> sources) {
		checkArgument(sources);		
		List<T> results = new ArrayList<>();
		
		for (S eachSource : sources) {
			List<T> eachResults = makeCopy(eachSource);
			results.addAll(eachResults);
		}
		
		return uniquify(results);
	}
	
	
	
	public List<T> makeCopy(S source) {
		checkArgument(source);	
		List<T> results = new ArrayList<>();
		
		S safeCopy = tryToClone(source);		
		results = makeCopyHook(safeCopy);
		return uniquify(results);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private S tryToClone(S source) {
		try {
			return (S) source.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalArgumentException(e);
		}
	}

	
	
	protected List<T> makeCopyHook(S source) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<T> uniquify(List<T> results) {
		if (resultUniquifier == null)
			return results;
		
		return resultUniquifier.uniquify(results);
	}
	
	
	
	private void checkArgument(InfoUniquifier<T> uniquifier) {
		if (uniquifier == null) {
			logException(new NullPointerException("uniquifier" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("uniquifier" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(S source) {
		if (source == null) {
			logException(new NullPointerException("source" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("source" + SystemMessage.NULL_ARGUMENT);
		}
	}	
	
	
	
	private void checkArgument(List<S> sources) {
		if (sources == null) {
			logException(new NullPointerException("sources" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sources" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sources.isEmpty()) {
			logException(new NullPointerException("sources" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("sources" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
