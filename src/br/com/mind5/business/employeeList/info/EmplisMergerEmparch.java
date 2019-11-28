package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplisMergerEmparch extends InfoMergerTemplate<EmplisInfo, EmparchInfo> {

	@Override protected InfoMergerVisitor<EmplisInfo, EmparchInfo> getVisitorHook() {
		return new EmplisVisiMergeEmparch();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
