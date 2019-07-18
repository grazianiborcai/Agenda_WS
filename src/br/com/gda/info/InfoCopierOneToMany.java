package br.com.gda.info;

import java.util.List;

public interface InfoCopierOneToMany<T extends InfoRecord, S extends InfoRecord> {
	public List<T> makeCopy(S source);
	
	
	public List<T> makeCopy(List<S> sources);
}
