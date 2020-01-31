package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplateMergerToSelect extends InfoMergerTemplate_<EmplateInfo, EmplateInfo> {

	@Override protected InfoMergerVisitor_<EmplateInfo, EmplateInfo> getVisitorHook() {
		return new EmplateVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
