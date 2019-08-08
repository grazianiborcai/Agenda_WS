package br.com.gda.business.employeeList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmplisMergerToSelect extends InfoMergerTemplate<EmplisInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<EmplisInfo, EmplisInfo> getVisitorHook() {
		return new EmplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
