package br.com.gda.business.orderSearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class OrdarchMerger {	
	public static OrdarchInfo mergeToSelect(OrdarchInfo sourceOne, OrdarchInfo sourceTwo) {
		InfoMerger<OrdarchInfo, OrdarchInfo> merger = new OrdarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdarchInfo> mergeToSelect(List<OrdarchInfo> sourceOnes, List<OrdarchInfo> sourceTwos) {
		InfoMerger<OrdarchInfo, OrdarchInfo> merger = new OrdarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
