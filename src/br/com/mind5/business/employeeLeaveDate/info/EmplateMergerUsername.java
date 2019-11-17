package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmplateMergerUsername extends InfoMergerTemplate<EmplateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<EmplateInfo, UsernameInfo> getVisitorHook() {
		return new EmplateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
