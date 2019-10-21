package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatMergerToSelect extends InfoMergerTemplate<EmpmatInfo, EmpmatInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, EmpmatInfo> getVisitorHook() {
		return new EmpmatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
