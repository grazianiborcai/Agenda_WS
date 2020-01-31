package br.com.mind5.business.employeeSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmparchMergerToSelect extends InfoMergerTemplate_<EmparchInfo, EmparchInfo> {

	@Override protected InfoMergerVisitor_<EmparchInfo, EmparchInfo> getVisitorHook() {
		return new EmparchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmparchInfo> getUniquifierHook() {
		return new EmparchUniquifier();
	}
}
