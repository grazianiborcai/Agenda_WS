package br.com.mind5.business.storeWorkTimeSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class StowotarchMerger {
	public static StowotarchInfo mergeToSelect(StowotarchInfo sourceOne, StowotarchInfo sourceTwo) {
		InfoMerger_<StowotarchInfo, StowotarchInfo> merger = new StowotarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotarchInfo> mergeToSelect(List<StowotarchInfo> sourceOnes, List<StowotarchInfo> sourceTwos) {
		InfoMerger_<StowotarchInfo, StowotarchInfo> merger = new StowotarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
