package br.com.mind5.security.userPassword.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckUser extends ModelCheckerTemplateForwardV2<UpswdInfo, UserInfo> {
	
	public UpswdCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(UpswdInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}
