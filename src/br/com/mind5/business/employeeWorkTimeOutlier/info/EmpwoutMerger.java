package br.com.mind5.business.employeeWorkTimeOutlier.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class EmpwoutMerger {
	public static EmpwoutInfo mergeToSelect(EmpwoutInfo sourceOne, EmpwoutInfo sourceTwo) {
		InfoMerger<EmpwoutInfo, EmpwoutInfo> merger = new EmpwoutMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwoutInfo> mergeToSelect(List<EmpwoutInfo> sourceOnes, List<EmpwoutInfo> sourceTwos) {
		InfoMerger<EmpwoutInfo, EmpwoutInfo> merger = new EmpwoutMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
