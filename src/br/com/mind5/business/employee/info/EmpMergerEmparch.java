package br.com.mind5.business.employee.info;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerEmparch extends InfoMergerTemplate_<EmpInfo, EmparchInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, EmparchInfo> getVisitorHook() {
		return new EmpVisiMergeEmparch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
