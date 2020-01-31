package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmatMergerToSelect extends InfoMergerTemplate_<EmpmatInfo, EmpmatInfo> {

	@Override protected InfoMergerVisitor_<EmpmatInfo, EmpmatInfo> getVisitorHook() {
		return new EmpmatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
