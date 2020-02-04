package br.com.mind5.info.obsolete;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface InfoMergerOneToMany_<T extends InfoRecord, K extends InfoRecord> {
	
	public List<T> merge(List<K> sourceOnes, List<T> sourceTwos);
	public List<T> merge(K sourceOne, T sourceTwo);
}
