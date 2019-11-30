package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatMergerEmpmarch extends InfoMergerTemplate<EmpmatInfo, EmpmarchInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, EmpmarchInfo> getVisitorHook() {
		return new EmpmatVisiMergeEmpmarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
