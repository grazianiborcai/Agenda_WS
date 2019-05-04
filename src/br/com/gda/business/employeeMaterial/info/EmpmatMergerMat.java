package br.com.gda.business.employeeMaterial.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpmatMergerMat extends InfoMergerTemplate<EmpmatInfo, MatInfo> {

	@Override protected InfoMergerVisitorV2<EmpmatInfo, MatInfo> getVisitorHook() {
		return new EmpmatVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
