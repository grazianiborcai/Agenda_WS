package br.com.mind5.business.customerList.info;


import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;

public final class CuslisMerger {
	public static CuslisInfo mergeWithFimist(FimistInfo sourceOne, CuslisInfo sourceTwo) {
		InfoMerger<CuslisInfo, FimistInfo> merger = new CuslisMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CuslisInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<CuslisInfo> sourceTwos) {
		InfoMerger<CuslisInfo, FimistInfo> merger = new CuslisMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CuslisInfo mergeWithCusarch(CusarchInfo sourceOne, CuslisInfo sourceTwo) {
		InfoMerger<CuslisInfo, CusarchInfo> merger = new CuslisMergerCusarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CuslisInfo> mergeWithCusarch(List<CusarchInfo> sourceOnes, List<CuslisInfo> sourceTwos) {
		InfoMerger<CuslisInfo, CusarchInfo> merger = new CuslisMergerCusarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
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
