package br.com.mind5.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class EmpwocoMerger {
	public static EmpwocoInfo mergeToSelect(EmpwocoInfo sourceOne, EmpwocoInfo sourceTwo) {
		InfoMerger<EmpwocoInfo, EmpwocoInfo> merger = new EmpwocoMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwocoInfo> mergeToSelect(List<EmpwocoInfo> sourceOnes, List<EmpwocoInfo> sourceTwos) {
		InfoMerger<EmpwocoInfo, EmpwocoInfo> merger = new EmpwocoMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
