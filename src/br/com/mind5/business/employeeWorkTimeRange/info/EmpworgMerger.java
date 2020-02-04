package br.com.mind5.business.employeeWorkTimeRange.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class EmpworgMerger {
	public static EmpworgInfo mergeToSelect(EmpworgInfo sourceOne, EmpworgInfo sourceTwo) {
		InfoMerger_<EmpworgInfo, EmpworgInfo> merger = new EmpworgMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpworgInfo> mergeToSelect(List<EmpworgInfo> sourceOnes, List<EmpworgInfo> sourceTwos) {
		InfoMerger_<EmpworgInfo, EmpworgInfo> merger = new EmpworgMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
