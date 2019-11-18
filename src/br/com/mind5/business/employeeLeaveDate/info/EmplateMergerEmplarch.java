package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplateMergerEmplarch extends InfoMergerTemplate<EmplateInfo, EmplarchInfo> {

	@Override protected InfoMergerVisitor<EmplateInfo, EmplarchInfo> getVisitorHook() {
		return new EmplateVisiMergeEmplarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
