package br.com.gda.info;

import java.util.List;

public interface InfoMerger<T extends InfoRecord, K extends InfoRecord> {
	
	public List<T> merge(List<K> sourceOnes, List<T> sourceTwos);
	public T merge(K sourceOne, T sourceTwo);
}
