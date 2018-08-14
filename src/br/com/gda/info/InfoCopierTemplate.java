package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public class InfoCopierTemplate<T,S> implements InfoCopier<T,S> {
	private InfoUniquifier<T> resultUniquifier;
	
	
	public InfoCopierTemplate() {
		
	}
	
	
	
	public InfoCopierTemplate(InfoUniquifier<T> uniquifier) {
		checkArgument(uniquifier);
		resultUniquifier = uniquifier;
	}
	
	
	
	private void checkArgument(InfoUniquifier<T> uniquifier) {
		if (uniquifier == null)
			throw new NullPointerException("uniquifier" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	public T makeCopy(S source) {
		checkArgument(source);		
		return makeCopyHook(source);
	}
	
	
	
	private void checkArgument(S source) {
		if (source == null)
			throw new NullPointerException("source" + SystemMessage.NULL_ARGUMENT);
	}

	
	
	protected T makeCopyHook(S source) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}

	
	
	public List<T> makeCopy(List<S> sources) {
		checkArgument(sources);
		
		List<T> results = new ArrayList<>();
		
		for (S eachSource : sources) {
			T eachResult = makeCopy(eachSource);
			results.add(eachResult);
		}
		
		
		if (resultUniquifier == null)
			return results;
		
		return resultUniquifier.uniquify(results);
	}
	
	
	
	private void checkArgument(List<S> sources) {
		if (sources == null)
			throw new NullPointerException("sources" + SystemMessage.NULL_ARGUMENT);
		
		if (sources.isEmpty())
			throw new NullPointerException("sources" + SystemMessage.EMPTY_ARGUMENT);
	}
}
