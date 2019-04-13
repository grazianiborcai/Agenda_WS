package br.com.gda.business.employeeLeaveDate.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class EmplevateMergerToDelete extends InfoMerger<EmplevateInfo, EmplevateInfo, EmplevateInfo> {
	public EmplevateInfo merge(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmplevateVisiMergeToDelete());
	}
	
	
	
	public List<EmplevateInfo> merge(List<EmplevateInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmplevateVisiMergeToDelete());
	}
}
