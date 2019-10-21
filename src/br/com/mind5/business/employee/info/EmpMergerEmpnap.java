package br.com.mind5.business.employee.info;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerEmpnap extends InfoMergerTemplate<EmpInfo, EmpnapInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, EmpnapInfo> getVisitorHook() {
		return new EmpVisiMergeEmpnap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
