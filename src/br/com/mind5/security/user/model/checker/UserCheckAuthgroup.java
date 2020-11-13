package br.com.mind5.security.user.model.checker;

import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.masterData.authorizationGroup.model.checker.AuthgroupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckAuthgroup extends ModelCheckerTemplateForward<UserInfo, AuthgroupInfo> {
	
	public UserCheckAuthgroup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AuthgroupInfo> getCheckerHook(ModelCheckerOption option) {
		return new AuthgroupCheckExist(option);
	}
	
	
	
	@Override protected AuthgroupInfo toForwardClass(UserInfo baseRecord) {
		return AuthgroupInfo.copyFrom(baseRecord);
	}
}
