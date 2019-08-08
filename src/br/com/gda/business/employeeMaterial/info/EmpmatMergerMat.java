package br.com.gda.business.employeeMaterial.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpmatMergerMat extends InfoMergerTemplate<EmpmatInfo, MatInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, MatInfo> getVisitorHook() {
		return new EmpmatVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
