package br.com.mind5.business.home.model.checker;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistManager;

public final class HomeCheckAuthManager extends ModelCheckerTemplateForward<HomeInfo, UserarchInfo> {
	
	public HomeCheckAuthManager(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistManager(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(HomeInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
