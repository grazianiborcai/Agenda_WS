package br.com.gda.business.employeeMaterial.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpmatMergerToSelect extends InfoMergerTemplate<EmpmatInfo, EmpmatInfo> {

	@Override protected InfoMergerVisitorV2<EmpmatInfo, EmpmatInfo> getVisitorHook() {
		return new EmpmatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
