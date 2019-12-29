package br.com.mind5.security.userList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class UselisMergerUserarch extends InfoMergerTemplate<UselisInfo, UserarchInfo> {

	@Override protected InfoMergerVisitor<UselisInfo, UserarchInfo> getVisitorHook() {
		return new UselisVisiMergeUserarch();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
