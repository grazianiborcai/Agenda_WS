package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistCustomer;

public final class StuntmCheckAuthCustomer extends ModelCheckerTemplateForward<StuntmInfo, UserarchInfo> {
	
	public StuntmCheckAuthCustomer(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistCustomer(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(StuntmInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
