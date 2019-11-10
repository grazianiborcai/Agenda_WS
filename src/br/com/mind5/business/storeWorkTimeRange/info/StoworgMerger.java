package br.com.mind5.business.storeWorkTimeRange.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class StoworgMerger {
	public static StoworgInfo mergeToSelect(StoworgInfo sourceOne, StoworgInfo sourceTwo) {
		InfoMerger<StoworgInfo, StoworgInfo> merger = new StoworgMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoworgInfo> mergeToSelect(List<StoworgInfo> sourceOnes, List<StoworgInfo> sourceTwos) {
		InfoMerger<StoworgInfo, StoworgInfo> merger = new StoworgMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
