package br.com.mind5.business.customerSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class CusarchMerger {	
	public static CusarchInfo mergeToSelect(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		InfoMerger_<CusarchInfo, CusarchInfo> merger = new CusarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusarchInfo> mergeToSelect(List<CusarchInfo> sourceOnes, List<CusarchInfo> sourceTwos) {
		InfoMerger_<CusarchInfo, CusarchInfo> merger = new CusarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
