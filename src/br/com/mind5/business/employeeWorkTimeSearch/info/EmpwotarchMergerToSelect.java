package br.com.mind5.business.employeeWorkTimeSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotarchMergerToSelect extends InfoMergerTemplate<EmpwotarchInfo, EmpwotarchInfo> {

	@Override protected InfoMergerVisitor<EmpwotarchInfo, EmpwotarchInfo> getVisitorHook() {
		return new EmpwotarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotarchInfo> getUniquifierHook() {
		return new EmpwotarchUniquifier();
	}
}
