package br.com.mind5.info;

import java.util.List;

public interface InfoMergerVisitor<T extends InfoRecord, K extends InfoRecord> {
	
	public List<T> merge(T baseInfo, K selectedInfo);
	public List<T> beforeMerge(List<T> baseInfos);
	public List<T> afterMerge(List<T> results);
	public boolean shouldMerge(T baseInfo, K selectedInfo);
	public List<T> uniquify(List<T> results);
//	public InfoUniquifier<T> getUniquifier();
	public InfoMergerCardinality getCardinality();
}
