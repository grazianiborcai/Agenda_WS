package br.com.gda.business.customerList.info;


import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.info.InfoMerger;

public final class CuslisMerger {
	public static CuslisInfo mergeWithPersolis(PersolisInfo sourceOne, CuslisInfo sourceTwo) {
		InfoMerger<CuslisInfo, PersolisInfo> merger = new CuslisMergerPersolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CuslisInfo> mergeWithPersolis(List<PersolisInfo> sourceOnes, List<CuslisInfo> sourceTwos) {
		InfoMerger<CuslisInfo, PersolisInfo> merger = new CuslisMergerPersolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CuslisInfo mergeToSelect(CuslisInfo sourceOne, CuslisInfo sourceTwo) {
		InfoMerger<CuslisInfo, CuslisInfo> merger = new CuslisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CuslisInfo> mergeToSelect(List<CuslisInfo> sourceOnes, List<CuslisInfo> sourceTwos) {
		InfoMerger<CuslisInfo, CuslisInfo> merger = new CuslisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
