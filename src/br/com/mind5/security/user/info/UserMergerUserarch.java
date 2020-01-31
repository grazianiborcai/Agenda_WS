package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class UserMergerUserarch extends InfoMergerTemplate_<UserInfo, UserarchInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, UserarchInfo> getVisitorHook() {
		return new UserVisiMergeUserarch();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
