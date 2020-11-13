package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;

public final class StoreCheckUser extends ModelCheckerTemplateForward<StoreInfo, UserInfo> {
	
	public StoreCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(StoreInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}
