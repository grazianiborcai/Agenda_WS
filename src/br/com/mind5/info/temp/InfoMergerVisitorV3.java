package br.com.mind5.info.temp;

import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.info.InfoUniquifier;

public interface InfoMergerVisitorV3<T extends InfoRecord, K extends InfoRecord> {
	
	public List<T> merge(T baseInfo, K selectedInfo);
	public List<T> beforeMerge(List<T> baseInfos);
	public boolean shouldMerge(T baseInfo, K selectedInfo);
	public InfoUniquifier<T> getUniquifier();
}
