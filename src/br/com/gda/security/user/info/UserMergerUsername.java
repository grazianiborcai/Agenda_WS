package br.com.gda.security.user.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class UserMergerUsername extends InfoMergerTemplate<UserInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<UserInfo, UsernameInfo> getVisitorHook() {
		return new UserVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
