package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class UserMergerUserarch extends InfoMergerTemplate<UserInfo, UserarchInfo> {

	@Override protected InfoMergerVisitor<UserInfo, UserarchInfo> getVisitorHook() {
		return new UserVisiMergeUserarch();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
