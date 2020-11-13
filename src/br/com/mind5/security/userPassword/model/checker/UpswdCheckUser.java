package br.com.mind5.security.userPassword.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckUser extends ModelCheckerTemplateForward<UpswdInfo, UserInfo> {
	
	public UpswdCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(UpswdInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}
