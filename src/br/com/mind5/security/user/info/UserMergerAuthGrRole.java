package br.com.mind5.security.user.info;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserMergerAuthGrRole extends InfoMergerTemplate_<UserInfo, AuthGrRoleInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, AuthGrRoleInfo> getVisitorHook() {
		return new UserVisiMergeAuthGrRole();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
