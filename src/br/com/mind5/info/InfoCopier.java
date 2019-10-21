package br.com.mind5.info;

import java.util.List;

public interface InfoCopier<T extends InfoRecord, S extends InfoRecord> {
	public T makeCopy(S source);
	
	
	public List<T> makeCopy(List<S> sources);
}
