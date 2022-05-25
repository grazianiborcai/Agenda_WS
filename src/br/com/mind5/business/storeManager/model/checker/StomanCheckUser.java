package br.com.mind5.business.storeManager.model.checker;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;

public final class StomanCheckUser extends ModelCheckerTemplateForward<StomanInfo, UserInfo> {
	
	public StomanCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(StomanInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}
