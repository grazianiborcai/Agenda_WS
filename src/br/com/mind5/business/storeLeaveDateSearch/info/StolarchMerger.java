package br.com.mind5.business.storeLeaveDateSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;


public final class StolarchMerger {
	public static StolarchInfo mergeToSelect(StolarchInfo sourceOne, StolarchInfo sourceTwo) {
		InfoMerger_<StolarchInfo, StolarchInfo> merger = new StolarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolarchInfo> mergeToSelect(List<StolarchInfo> sourceOnes, List<StolarchInfo> sourceTwos) {
		InfoMerger_<StolarchInfo, StolarchInfo> merger = new StolarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
