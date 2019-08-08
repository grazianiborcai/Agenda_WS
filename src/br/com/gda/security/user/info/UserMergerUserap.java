package br.com.gda.security.user.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userSnapshot.info.UserapInfo;

final class UserMergerUserap extends InfoMergerTemplate<UserInfo, UserapInfo> {

	@Override protected InfoMergerVisitorV2<UserInfo, UserapInfo> getVisitorHook() {
		return new UserVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
