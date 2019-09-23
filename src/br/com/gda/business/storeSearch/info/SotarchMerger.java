package br.com.gda.business.storeSearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class SotarchMerger {	
	public static SotarchInfo mergeToSelect(SotarchInfo sourceOne, SotarchInfo sourceTwo) {
		InfoMerger<SotarchInfo, SotarchInfo> merger = new SotarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SotarchInfo> mergeToSelect(List<SotarchInfo> sourceOnes, List<SotarchInfo> sourceTwos) {
		InfoMerger<SotarchInfo, SotarchInfo> merger = new SotarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
