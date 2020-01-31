package br.com.mind5.business.employee.info;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerEmpnap extends InfoMergerTemplate_<EmpInfo, EmpnapInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, EmpnapInfo> getVisitorHook() {
		return new EmpVisiMergeEmpnap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
