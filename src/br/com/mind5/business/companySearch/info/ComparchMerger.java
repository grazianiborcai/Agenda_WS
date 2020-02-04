package br.com.mind5.business.companySearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class ComparchMerger {	
	public static ComparchInfo mergeToSelect(ComparchInfo sourceOne, ComparchInfo sourceTwo) {
		InfoMerger_<ComparchInfo, ComparchInfo> merger = new ComparchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ComparchInfo> mergeToSelect(List<ComparchInfo> sourceOnes, List<ComparchInfo> sourceTwos) {
		InfoMerger_<ComparchInfo, ComparchInfo> merger = new ComparchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
