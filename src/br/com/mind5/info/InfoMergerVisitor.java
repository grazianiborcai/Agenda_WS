package br.com.mind5.info;

import java.util.List;

public interface InfoMergerVisitor<T extends InfoRecord, K extends InfoRecord> {
	
	public List<T> merge(T baseInfo, K selectedInfo);
	public List<T> beforeMerge(List<T> baseInfos);
	public boolean shouldMerge(T baseInfo, K selectedInfo);
	public InfoUniquifier<T> getUniquifier();
}
