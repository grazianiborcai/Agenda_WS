package br.com.gda.info;

import java.util.List;

public interface InfoMergerOneToMany<T extends InfoRecord, K extends InfoRecord> {
	
	public List<T> merge(List<K> sourceOnes, List<T> sourceTwos);
	public List<T> merge(K sourceOne, T sourceTwo);
}
