package br.com.gda.business.materialEmployee.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.RecordMerger;

final class MatEmpMergerEmp extends RecordMerger<MatEmpInfo, EmpInfo, MatEmpInfo> {
	public MatEmpInfo merge(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new MatEmpVisitorEmp());
	}
	
	
	
	public List<MatEmpInfo> merge(List<EmpInfo> sourceOnes, List<MatEmpInfo> sourceTwos) {		
		return super.merge(sourceOnes, sourceTwos, new MatEmpVisitorEmp());
	}
}
