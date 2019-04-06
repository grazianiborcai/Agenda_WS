package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class EmpMergerToDelete extends InfoMerger<EmpInfo, EmpInfo, EmpInfo> {
	public EmpInfo merge(EmpInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpVisiMergeToDelete());
	}
	
	
	
	public List<EmpInfo> merge(List<EmpInfo> sourceOnes, List<EmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpVisiMergeToDelete());
	}
}
