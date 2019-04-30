package br.com.gda.business.user.info;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class UserMergerAuthGrRole extends InfoMergerTemplate<UserInfo, AuthGrRoleInfo> {

	@Override protected InfoMergerVisitorV2<UserInfo, AuthGrRoleInfo> getVisitorHook() {
		return new UserVisiMergeAuthGrRole();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
