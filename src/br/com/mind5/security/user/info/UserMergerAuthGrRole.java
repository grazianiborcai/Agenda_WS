package br.com.mind5.security.user.info;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerAuthGrRole extends InfoMergerTemplate<UserInfo, AuthGrRoleInfo> {

	@Override protected InfoMergerVisitor<UserInfo, AuthGrRoleInfo> getVisitorHook() {
		return new UserVisiMergeAuthGrRole();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
