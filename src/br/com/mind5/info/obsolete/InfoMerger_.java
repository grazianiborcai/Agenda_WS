package br.com.mind5.info.obsolete;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface InfoMerger_<T extends InfoRecord, K extends InfoRecord> {
	
	public List<T> merge(List<K> selectedInfos, List<T> baseInfos);
	public T merge(K selectedInfo, T baseInfo);
}
