package br.com.mind5.business.materialStoreSnapshot.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatorapMerger {
	public static MatorapInfo mergeToSelect(MatorapInfo sourceOne, MatorapInfo sourceTwo) {
		InfoMerger_<MatorapInfo, MatorapInfo> merger = new MatorapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatorapInfo> mergeToSelect(List<MatorapInfo> sourceOnes, List<MatorapInfo> sourceTwos) {
		InfoMerger_<MatorapInfo, MatorapInfo> merger = new MatorapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
