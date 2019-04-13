package br.com.gda.business.employeeMaterial.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoMerger;

final class EmpmatMergerEmp extends InfoMerger<EmpmatInfo, EmpInfo, EmpmatInfo> {
	public EmpmatInfo merge(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpmatVisiMergeEmp());
	}
	
	
	
	public List<EmpmatInfo> merge(List<EmpInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpmatVisiMergeEmp());
	}
}
