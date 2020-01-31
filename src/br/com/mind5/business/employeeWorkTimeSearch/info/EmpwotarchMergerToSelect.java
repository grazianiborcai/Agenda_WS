package br.com.mind5.business.employeeWorkTimeSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotarchMergerToSelect extends InfoMergerTemplate_<EmpwotarchInfo, EmpwotarchInfo> {

	@Override protected InfoMergerVisitor_<EmpwotarchInfo, EmpwotarchInfo> getVisitorHook() {
		return new EmpwotarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotarchInfo> getUniquifierHook() {
		return new EmpwotarchUniquifier();
	}
}
