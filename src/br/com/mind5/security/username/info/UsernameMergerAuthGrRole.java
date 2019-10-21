package br.com.mind5.security.username.info;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UsernameMergerAuthGrRole extends InfoMergerTemplate<UsernameInfo, AuthGrRoleInfo> {

	@Override protected InfoMergerVisitor<UsernameInfo, AuthGrRoleInfo> getVisitorHook() {
		return new UsernameVisiMergeAuthGrRole();
	}
	
	
	
	@Override protected InfoUniquifier<UsernameInfo> getUniquifierHook() {
		return new UsernameUniquifier();
	}
}
