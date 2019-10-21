package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatMergerMat extends InfoMergerTemplate<EmpmatInfo, MatInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, MatInfo> getVisitorHook() {
		return new EmpmatVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
