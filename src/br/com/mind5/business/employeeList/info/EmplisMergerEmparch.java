package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplisMergerEmparch extends InfoMergerTemplate_<EmplisInfo, EmparchInfo> {

	@Override protected InfoMergerVisitor_<EmplisInfo, EmparchInfo> getVisitorHook() {
		return new EmplisVisiMergeEmparch();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
