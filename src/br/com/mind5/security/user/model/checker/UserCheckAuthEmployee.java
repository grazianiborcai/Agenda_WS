package br.com.mind5.security.user.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistEmployee;

public final class UserCheckAuthEmployee extends ModelCheckerTemplateForward<UserInfo, UserarchInfo> {
	
	public UserCheckAuthEmployee(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistEmployee(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(UserInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
