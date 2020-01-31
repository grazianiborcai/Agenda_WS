package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmatMergerEmpmarch extends InfoMergerTemplate_<EmpmatInfo, EmpmarchInfo> {

	@Override protected InfoMergerVisitor_<EmpmatInfo, EmpmarchInfo> getVisitorHook() {
		return new EmpmatVisiMergeEmpmarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
