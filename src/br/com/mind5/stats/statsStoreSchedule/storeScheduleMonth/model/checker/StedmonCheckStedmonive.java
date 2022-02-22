package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckExist;

public final class StedmonCheckStedmonive extends ModelCheckerTemplateForward<StedmonInfo, StedmoniveInfo> {
	
	public StedmonCheckStedmonive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StedmoniveInfo> getCheckerHook(ModelCheckerOption option) {
		return new StedmoniveCheckExist(option);
	}
	
	
	
	@Override protected StedmoniveInfo toForwardClass(StedmonInfo baseRecord) {
		return StedmoniveInfo.copyFrom(baseRecord);
	}
}
