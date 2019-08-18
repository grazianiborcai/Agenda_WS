package br.com.gda.business.customerSearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class CusarchMerger {	
	public static CusarchInfo mergeToSelect(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		InfoMerger<CusarchInfo, CusarchInfo> merger = new CusarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusarchInfo> mergeToSelect(List<CusarchInfo> sourceOnes, List<CusarchInfo> sourceTwos) {
		InfoMerger<CusarchInfo, CusarchInfo> merger = new CusarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
