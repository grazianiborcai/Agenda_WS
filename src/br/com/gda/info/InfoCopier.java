package br.com.gda.info;

import java.util.List;

public interface InfoCopier<T,S> {
	public T makeCopy(S source);
	
	
	public List<T> makeCopy(List<S> sources);
}
