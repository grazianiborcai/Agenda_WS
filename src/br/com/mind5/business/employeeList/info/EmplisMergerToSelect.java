package br.com.mind5.business.employeeList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplisMergerToSelect extends InfoMergerTemplate_<EmplisInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<EmplisInfo, EmplisInfo> getVisitorHook() {
		return new EmplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
