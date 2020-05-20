package br.com.mind5.security.user.model.checker;

import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.masterData.authorizationGroup.model.checker.AuthgroupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckAuthgroup extends ModelCheckerTemplateForwardV2<UserInfo, AuthgroupInfo> {
	
	public UserCheckAuthgroup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AuthgroupInfo> getCheckerHook(ModelCheckerOption option) {
		return new AuthgroupCheckExist(option);
	}
	
	
	
	@Override protected AuthgroupInfo toForwardClass(UserInfo baseRecord) {
		return AuthgroupInfo.copyFrom(baseRecord);
	}
}
