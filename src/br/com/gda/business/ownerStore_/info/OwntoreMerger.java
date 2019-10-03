package br.com.gda.business.ownerStore_.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class OwntoreMerger {
	public static OwntoreInfo mergeToDelete(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {
		InfoMerger<OwntoreInfo, OwntoreInfo> merger = new OwntoreMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwntoreInfo> mergeToDelete(List<OwntoreInfo> sourceOnes, List<OwntoreInfo> sourceTwos) {
		InfoMerger<OwntoreInfo, OwntoreInfo> merger = new OwntoreMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OwntoreInfo mergeToSelect(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {
		InfoMerger<OwntoreInfo, OwntoreInfo> merger = new OwntoreMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwntoreInfo> mergeToSelect(List<OwntoreInfo> sourceOnes, List<OwntoreInfo> sourceTwos) {
		InfoMerger<OwntoreInfo, OwntoreInfo> merger = new OwntoreMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
