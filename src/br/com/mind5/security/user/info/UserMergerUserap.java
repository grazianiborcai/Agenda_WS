package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class UserMergerUserap extends InfoMergerTemplate_<UserInfo, UserapInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, UserapInfo> getVisitorHook() {
		return new UserVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
