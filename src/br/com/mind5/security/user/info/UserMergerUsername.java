package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class UserMergerUsername extends InfoMergerTemplate<UserInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<UserInfo, UsernameInfo> getVisitorHook() {
		return new UserVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
