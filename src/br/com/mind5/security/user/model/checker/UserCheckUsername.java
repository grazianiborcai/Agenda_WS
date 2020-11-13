package br.com.mind5.security.user.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class UserCheckUsername extends ModelCheckerTemplateForward<UserInfo, UsernameInfo> {
	
	public UserCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(UserInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
