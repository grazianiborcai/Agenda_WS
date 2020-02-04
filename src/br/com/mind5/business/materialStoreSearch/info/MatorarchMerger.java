package br.com.mind5.business.materialStoreSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatorarchMerger {
	public static MatorarchInfo mergeToSelect(MatorarchInfo sourceOne, MatorarchInfo sourceTwo) {
		InfoMerger_<MatorarchInfo, MatorarchInfo> merger = new MatorarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatorarchInfo> mergeToSelect(List<MatorarchInfo> sourceOnes, List<MatorarchInfo> sourceTwos) {
		InfoMerger_<MatorarchInfo, MatorarchInfo> merger = new MatorarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
