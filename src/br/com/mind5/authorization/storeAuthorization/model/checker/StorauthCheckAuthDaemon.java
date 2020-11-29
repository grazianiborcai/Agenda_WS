package br.com.mind5.authorization.storeAuthorization.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistDaemon;

public final class StorauthCheckAuthDaemon extends ModelCheckerTemplateForward<StorauthInfo, UserarchInfo> {
	
	public StorauthCheckAuthDaemon(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistDaemon(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(StorauthInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
