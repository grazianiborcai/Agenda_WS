package br.com.mind5.security.userList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class UselisMergerUserarch extends InfoMergerTemplate_<UselisInfo, UserarchInfo> {

	@Override protected InfoMergerVisitor_<UselisInfo, UserarchInfo> getVisitorHook() {
		return new UselisVisiMergeUserarch();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
