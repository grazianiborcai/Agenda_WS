package br.com.mind5.business.storeSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class SotarchMerger {	
	public static SotarchInfo mergeToSelect(SotarchInfo sourceOne, SotarchInfo sourceTwo) {
		InfoMerger_<SotarchInfo, SotarchInfo> merger = new SotarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SotarchInfo> mergeToSelect(List<SotarchInfo> sourceOnes, List<SotarchInfo> sourceTwos) {
		InfoMerger_<SotarchInfo, SotarchInfo> merger = new SotarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
