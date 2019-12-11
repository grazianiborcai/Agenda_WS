package br.com.mind5.business.materialStoreSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class MatorapMerger {
	public static MatorapInfo mergeToSelect(MatorapInfo sourceOne, MatorapInfo sourceTwo) {
		InfoMerger<MatorapInfo, MatorapInfo> merger = new MatorapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatorapInfo> mergeToSelect(List<MatorapInfo> sourceOnes, List<MatorapInfo> sourceTwos) {
		InfoMerger<MatorapInfo, MatorapInfo> merger = new MatorapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
