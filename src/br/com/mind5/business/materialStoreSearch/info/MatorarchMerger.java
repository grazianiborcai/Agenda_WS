package br.com.mind5.business.materialStoreSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class MatorarchMerger {
	public static MatorarchInfo mergeToSelect(MatorarchInfo sourceOne, MatorarchInfo sourceTwo) {
		InfoMerger<MatorarchInfo, MatorarchInfo> merger = new MatorarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatorarchInfo> mergeToSelect(List<MatorarchInfo> sourceOnes, List<MatorarchInfo> sourceTwos) {
		InfoMerger<MatorarchInfo, MatorarchInfo> merger = new MatorarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
