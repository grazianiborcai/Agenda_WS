package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplevateMergerToSelect extends InfoMergerTemplate<EmplevateInfo, EmplevateInfo> {

	@Override protected InfoMergerVisitor<EmplevateInfo, EmplevateInfo> getVisitorHook() {
		return new EmplevateVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
