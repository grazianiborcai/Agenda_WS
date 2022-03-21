package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;

public final class CustamoniveCheckAuthOwner extends ModelCheckerTemplateForward<CustamoniveInfo, UserarchInfo> {
	
	public CustamoniveCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(CustamoniveInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
