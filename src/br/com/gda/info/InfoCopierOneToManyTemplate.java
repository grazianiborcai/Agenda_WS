package br.com.gda.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public class InfoCopierOneToManyTemplate<T,S> implements InfoCopierOneToMany<T,S> {
	private InfoUniquifier<T> resultUniquifier;
	
	
	public InfoCopierOneToManyTemplate() {
		resultUniquifier = null;
	}
	
	
	
	public InfoCopierOneToManyTemplate(InfoUniquifier<T> uniquifier) {
		checkArgument(uniquifier);
		resultUniquifier = uniquifier;
	}
	
	
	
	private void checkArgument(InfoUniquifier<T> uniquifier) {
		if (uniquifier == null) {
			logException(new NullPointerException("uniquifier" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("uniquifier" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	public List<T> makeCopy(S source) {
		checkArgument(source);		
		return makeCopyHook(source);
	}
	
	
	
	private void checkArgument(S source) {
		if (source == null) {
			logException(new NullPointerException("source" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("source" + SystemMessage.NULL_ARGUMENT);
		}
	}

	
	
	protected List<T> makeCopyHook(S source) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
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
	
	
	
	private List<T> uniquify(List<T> results) {
		if (resultUniquifier == null)
			return results;
		
		return resultUniquifier.uniquify(results);
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
