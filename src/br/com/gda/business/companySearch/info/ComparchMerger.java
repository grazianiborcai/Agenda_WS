package br.com.gda.business.companySearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class ComparchMerger {	
	public static ComparchInfo mergeToSelect(ComparchInfo sourceOne, ComparchInfo sourceTwo) {
		InfoMerger<ComparchInfo, ComparchInfo> merger = new ComparchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ComparchInfo> mergeToSelect(List<ComparchInfo> sourceOnes, List<ComparchInfo> sourceTwos) {
		InfoMerger<ComparchInfo, ComparchInfo> merger = new ComparchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
