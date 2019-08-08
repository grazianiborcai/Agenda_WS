package br.com.gda.business.employee.info;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpMergerEmpnap extends InfoMergerTemplate<EmpInfo, EmpnapInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, EmpnapInfo> getVisitorHook() {
		return new EmpVisiMergeEmpnap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
