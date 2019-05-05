package br.com.gda.business.employeeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmplevateMergerToDelete extends InfoMergerTemplate<EmplevateInfo, EmplevateInfo> {

	@Override protected InfoMergerVisitorV2<EmplevateInfo, EmplevateInfo> getVisitorHook() {
		return new EmplevateVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
