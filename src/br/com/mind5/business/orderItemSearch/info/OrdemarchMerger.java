package br.com.mind5.business.orderItemSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class OrdemarchMerger {
	public static OrdemarchInfo mergeToSelect(OrdemarchInfo sourceOne, OrdemarchInfo sourceTwo) {
		InfoMerger<OrdemarchInfo, OrdemarchInfo> merger = new OrdemarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemarchInfo> mergeToSelect(List<OrdemarchInfo> sourceOnes, List<OrdemarchInfo> sourceTwos) {
		InfoMerger<OrdemarchInfo, OrdemarchInfo> merger = new OrdemarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
