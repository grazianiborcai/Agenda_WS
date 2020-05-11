package br.com.mind5.security.user.model.checker;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.business.masterData.model.checker.AuthGroupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckAuthGroup extends ModelCheckerTemplateForwardV2<UserInfo, AuthGroupInfo> {
	
	public UserCheckAuthGroup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AuthGroupInfo> getCheckerHook(ModelCheckerOption option) {
		return new AuthGroupCheckExist(option);
	}
	
	
	
	@Override protected AuthGroupInfo toForwardClass(UserInfo baseRecord) {
		return AuthGroupInfo.copyFrom(baseRecord);
	}
}
