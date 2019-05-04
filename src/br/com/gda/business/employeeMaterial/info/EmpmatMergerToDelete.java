package br.com.gda.business.employeeMaterial.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpmatMergerToDelete extends InfoMergerTemplate<EmpmatInfo, EmpmatInfo> {

	@Override protected InfoMergerVisitorV2<EmpmatInfo, EmpmatInfo> getVisitorHook() {
		return new EmpmatVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
