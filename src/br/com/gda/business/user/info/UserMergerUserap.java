package br.com.gda.business.user.info;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class UserMergerUserap extends InfoMergerTemplate<UserInfo, UserapInfo> {

	@Override protected InfoMergerVisitorV2<UserInfo, UserapInfo> getVisitorHook() {
		return new UserVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
