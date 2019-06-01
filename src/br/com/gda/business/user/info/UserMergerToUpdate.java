package br.com.gda.business.user.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class UserMergerToUpdate extends InfoMergerTemplate<UserInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<UserInfo, UserInfo> getVisitorHook() {
		return new UserVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
