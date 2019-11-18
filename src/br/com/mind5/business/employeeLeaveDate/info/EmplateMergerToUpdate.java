package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplateMergerToUpdate extends InfoMergerTemplate<EmplateInfo, EmplateInfo> {

	@Override protected InfoMergerVisitor<EmplateInfo, EmplateInfo> getVisitorHook() {
		return new EmplateVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
