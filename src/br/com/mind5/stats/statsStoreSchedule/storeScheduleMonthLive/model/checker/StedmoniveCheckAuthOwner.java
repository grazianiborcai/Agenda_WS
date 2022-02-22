package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StedmoniveCheckAuthOwner extends ModelCheckerTemplateForward<StedmoniveInfo, UserarchInfo> {
	
	public StedmoniveCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(StedmoniveInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
