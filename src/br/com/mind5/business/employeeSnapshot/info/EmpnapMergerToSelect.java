package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapMergerToSelect extends InfoMergerTemplate<EmpnapInfo, EmpnapInfo> {

	@Override protected InfoMergerVisitor<EmpnapInfo, EmpnapInfo> getVisitorHook() {
		return new EmpnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
