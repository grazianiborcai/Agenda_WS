package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerToDelete extends InfoMergerTemplate<UserInfo, UserInfo> {

	@Override protected InfoMergerVisitor<UserInfo, UserInfo> getVisitorHook() {
		return new UserVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
