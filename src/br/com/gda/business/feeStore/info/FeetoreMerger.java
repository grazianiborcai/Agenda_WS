package br.com.gda.business.feeStore.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class FeetoreMerger {	
	public static FeetoreInfo mergeToSelect(FeetoreInfo sourceOne, FeetoreInfo sourceTwo) {
		InfoMerger<FeetoreInfo, FeetoreInfo> merger = new FeetoreMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FeetoreInfo> mergeToSelect(List<FeetoreInfo> sourceOnes, List<FeetoreInfo> sourceTwos) {
		InfoMerger<FeetoreInfo, FeetoreInfo> merger = new FeetoreMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
