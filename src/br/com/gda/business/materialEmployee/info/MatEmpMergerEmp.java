package br.com.gda.business.materialEmployee.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoWriter;

final class MatEmpMergerEmp extends InfoWriter<MatEmpInfo, EmpInfo, MatEmpInfo> {
	public MatEmpInfo merge(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatEmpVisitorEmp());
	}
	
	
	
	public List<MatEmpInfo> merge(List<EmpInfo> sourceOnes, List<MatEmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatEmpVisitorEmp());
	}
}
