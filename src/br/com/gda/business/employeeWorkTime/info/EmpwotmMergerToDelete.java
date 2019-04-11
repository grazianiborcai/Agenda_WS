package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class EmpwotmMergerToDelete extends InfoMerger<EmpwotmInfo, EmpwotmInfo, EmpwotmInfo> {
	public EmpwotmInfo merge(EmpwotmInfo sourceOne, EmpwotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwotmVisiMergeToDelete());
	}
	
	
	
	public List<EmpwotmInfo> merge(List<EmpwotmInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpwotmVisiMergeToDelete());
	}
}
