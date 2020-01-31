package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpnapMergerToSelect extends InfoMergerTemplate_<EmpnapInfo, EmpnapInfo> {

	@Override protected InfoMergerVisitor_<EmpnapInfo, EmpnapInfo> getVisitorHook() {
		return new EmpnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
