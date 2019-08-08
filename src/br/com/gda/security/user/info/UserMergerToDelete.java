package br.com.gda.security.user.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserMergerToDelete extends InfoMergerTemplate<UserInfo, UserInfo> {

	@Override protected InfoMergerVisitor<UserInfo, UserInfo> getVisitorHook() {
		return new UserVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
