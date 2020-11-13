package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistCustomer;

public final class StowotmCheckAuthCustomer extends ModelCheckerTemplateForward<StowotmInfo, UserarchInfo> {
	
	public StowotmCheckAuthCustomer(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistCustomer(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(StowotmInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
