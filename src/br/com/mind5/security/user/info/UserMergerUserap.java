package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class UserMergerUserap extends InfoMergerTemplate<UserInfo, UserapInfo> {

	@Override protected InfoMergerVisitor<UserInfo, UserapInfo> getVisitorHook() {
		return new UserVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
