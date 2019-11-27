package br.com.mind5.business.employee.info;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerEmparch extends InfoMergerTemplate<EmpInfo, EmparchInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, EmparchInfo> getVisitorHook() {
		return new EmpVisiMergeEmparch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
