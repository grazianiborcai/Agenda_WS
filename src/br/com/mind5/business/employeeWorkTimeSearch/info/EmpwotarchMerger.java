package br.com.mind5.business.employeeWorkTimeSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class EmpwotarchMerger {	
	public static EmpwotarchInfo mergeToSelect(EmpwotarchInfo sourceOne, EmpwotarchInfo sourceTwo) {
		InfoMerger_<EmpwotarchInfo, EmpwotarchInfo> merger = new EmpwotarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotarchInfo> mergeToSelect(List<EmpwotarchInfo> sourceOnes, List<EmpwotarchInfo> sourceTwos) {
		InfoMerger_<EmpwotarchInfo, EmpwotarchInfo> merger = new EmpwotarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
