package br.com.mind5.business.companySnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class CompnapMerger {
	public static CompnapInfo mergeToSelect(CompnapInfo sourceOne, CompnapInfo sourceTwo) {
		InfoMerger<CompnapInfo, CompnapInfo> merger = new CompnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CompnapInfo> mergeToSelect(List<CompnapInfo> sourceOnes, List<CompnapInfo> sourceTwos) {
		InfoMerger<CompnapInfo, CompnapInfo> merger = new CompnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
