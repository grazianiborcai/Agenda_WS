package br.com.mind5.business.employeeList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplisMergerToSelect extends InfoMergerTemplate<EmplisInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<EmplisInfo, EmplisInfo> getVisitorHook() {
		return new EmplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
