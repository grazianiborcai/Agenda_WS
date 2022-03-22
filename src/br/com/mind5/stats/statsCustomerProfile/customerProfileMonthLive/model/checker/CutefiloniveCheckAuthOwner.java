package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

public final class CutefiloniveCheckAuthOwner extends ModelCheckerTemplateForward<CutefiloniveInfo, UserarchInfo> {
	
	public CutefiloniveCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(CutefiloniveInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
