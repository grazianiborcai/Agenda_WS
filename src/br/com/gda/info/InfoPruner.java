package br.com.gda.info;

import java.util.List;

public interface InfoPruner<T extends InfoRecord, S extends InfoRecord> {
	
	public List<T> prune(List<T> sourceOnes, List<S> sourceTwos);
}
