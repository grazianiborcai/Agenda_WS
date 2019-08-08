package br.com.gda.security.user.info;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserMergerAuthGrRole extends InfoMergerTemplate<UserInfo, AuthGrRoleInfo> {

	@Override protected InfoMergerVisitor<UserInfo, AuthGrRoleInfo> getVisitorHook() {
		return new UserVisiMergeAuthGrRole();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
