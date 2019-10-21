package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatMergerToDelete extends InfoMergerTemplate<EmpmatInfo, EmpmatInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, EmpmatInfo> getVisitorHook() {
		return new EmpmatVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
