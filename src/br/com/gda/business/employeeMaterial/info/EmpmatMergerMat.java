package br.com.gda.business.employeeMaterial.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;

final class EmpmatMergerMat extends InfoMerger<EmpmatInfo, MatInfo, EmpmatInfo> {
	public EmpmatInfo merge(MatInfo sourceOne, EmpmatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpmatVisiMergeMat());
	}
	
	
	
	public List<EmpmatInfo> merge(List<MatInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpmatVisiMergeMat());
	}
}
