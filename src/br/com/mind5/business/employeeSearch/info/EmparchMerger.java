package br.com.mind5.business.employeeSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class EmparchMerger {
	public static EmparchInfo mergeToSelect(EmparchInfo sourceOne, EmparchInfo sourceTwo) {
		InfoMerger_<EmparchInfo, EmparchInfo> merger = new EmparchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmparchInfo> mergeToSelect(List<EmparchInfo> sourceOnes, List<EmparchInfo> sourceTwos) {
		InfoMerger_<EmparchInfo, EmparchInfo> merger = new EmparchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
