package br.com.mind5.business.employeeSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmparchMergerToSelect extends InfoMergerTemplate<EmparchInfo, EmparchInfo> {

	@Override protected InfoMergerVisitor<EmparchInfo, EmparchInfo> getVisitorHook() {
		return new EmparchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmparchInfo> getUniquifierHook() {
		return new EmparchUniquifier();
	}
}
