package br.com.gda.business.employeeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmplevateMergerToSelect extends InfoMergerTemplate<EmplevateInfo, EmplevateInfo> {

	@Override protected InfoMergerVisitor<EmplevateInfo, EmplevateInfo> getVisitorHook() {
		return new EmplevateVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
