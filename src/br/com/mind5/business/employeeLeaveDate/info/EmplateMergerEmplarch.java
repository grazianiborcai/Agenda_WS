package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplateMergerEmplarch extends InfoMergerTemplate_<EmplateInfo, EmplarchInfo> {

	@Override protected InfoMergerVisitor_<EmplateInfo, EmplarchInfo> getVisitorHook() {
		return new EmplateVisiMergeEmplarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
