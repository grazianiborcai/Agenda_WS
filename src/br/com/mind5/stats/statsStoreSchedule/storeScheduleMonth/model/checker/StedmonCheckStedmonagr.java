package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckExist;

public final class StedmonCheckStedmonagr extends ModelCheckerTemplateForward<StedmonInfo, StedmonagrInfo> {
	
	public StedmonCheckStedmonagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StedmonagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new StedmonagrCheckExist(option);
	}
	
	
	
	@Override protected StedmonagrInfo toForwardClass(StedmonInfo baseRecord) {
		return StedmonagrInfo.copyFrom(baseRecord);
	}
}
