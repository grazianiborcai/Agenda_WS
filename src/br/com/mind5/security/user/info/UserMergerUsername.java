package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class UserMergerUsername extends InfoMergerTemplate_<UserInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, UsernameInfo> getVisitorHook() {
		return new UserVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
