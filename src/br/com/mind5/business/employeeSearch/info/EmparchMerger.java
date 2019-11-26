package br.com.mind5.business.employeeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class EmparchMerger {
	public static EmparchInfo mergeToSelect(EmparchInfo sourceOne, EmparchInfo sourceTwo) {
		InfoMerger<EmparchInfo, EmparchInfo> merger = new EmparchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmparchInfo> mergeToSelect(List<EmparchInfo> sourceOnes, List<EmparchInfo> sourceTwos) {
		InfoMerger<EmparchInfo, EmparchInfo> merger = new EmparchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
