package br.com.gda.business.personSearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class PerarchMerger {
	public static PerarchInfo mergeToSelect(PerarchInfo sourceOne, PerarchInfo sourceTwo) {
		InfoMerger<PerarchInfo, PerarchInfo> merger = new PerarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PerarchInfo> mergeToSelect(List<PerarchInfo> sourceOnes, List<PerarchInfo> sourceTwos) {
		InfoMerger<PerarchInfo, PerarchInfo> merger = new PerarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
