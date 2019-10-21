package br.com.mind5.business.customerList.info;


import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMerger;

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
