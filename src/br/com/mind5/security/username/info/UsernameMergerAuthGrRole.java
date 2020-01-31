package br.com.mind5.security.username.info;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UsernameMergerAuthGrRole extends InfoMergerTemplate_<UsernameInfo, AuthGrRoleInfo> {

	@Override protected InfoMergerVisitor_<UsernameInfo, AuthGrRoleInfo> getVisitorHook() {
		return new UsernameVisiMergeAuthGrRole();
	}
	
	
	
	@Override protected InfoUniquifier<UsernameInfo> getUniquifierHook() {
		return new UsernameUniquifier();
	}
}
