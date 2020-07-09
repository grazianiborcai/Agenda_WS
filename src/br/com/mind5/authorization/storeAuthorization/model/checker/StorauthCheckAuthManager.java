package br.com.mind5.authorization.storeAuthorization.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistManager;

public final class StorauthCheckAuthManager extends ModelCheckerTemplateForwardV2<StorauthInfo, UserarchInfo> {
	
	public StorauthCheckAuthManager(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistManager(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(StorauthInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
