package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmplateMergerUsername extends InfoMergerTemplate_<EmplateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<EmplateInfo, UsernameInfo> getVisitorHook() {
		return new EmplateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmplateInfo> getUniquifierHook() {
		return new EmplateUniquifier();
	}
}
