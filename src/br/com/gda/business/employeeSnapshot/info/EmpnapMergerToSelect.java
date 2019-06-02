package br.com.gda.business.employeeSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerToSelect extends InfoMergerTemplate<EmpnapInfo, EmpnapInfo> {

	@Override protected InfoMergerVisitorV2<EmpnapInfo, EmpnapInfo> getVisitorHook() {
		return new EmpnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
