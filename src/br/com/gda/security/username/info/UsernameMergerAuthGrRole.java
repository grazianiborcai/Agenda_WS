package br.com.gda.security.username.info;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class UsernameMergerAuthGrRole extends InfoMergerTemplate<UsernameInfo, AuthGrRoleInfo> {

	@Override protected InfoMergerVisitorV2<UsernameInfo, AuthGrRoleInfo> getVisitorHook() {
		return new UsernameVisiMergeAuthGrRole();
	}
	
	
	
	@Override protected InfoUniquifier<UsernameInfo> getUniquifierHook() {
		return new UsernameUniquifier();
	}
}
