package br.com.gda.business.employeeMaterial.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class EmpmatMergerToDelete extends InfoMerger_<EmpmatInfo, EmpmatInfo, EmpmatInfo> {
	public EmpmatInfo merge(EmpmatInfo sourceOne, EmpmatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpmatVisiMergeToDelete());
	}
	
	
	
	public List<EmpmatInfo> merge(List<EmpmatInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpmatVisiMergeToDelete());
	}
}
