package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckExist;

public final class SteddCheckSteddagr extends ModelCheckerTemplateForward<SteddInfo, SteddagrInfo> {
	
	public SteddCheckSteddagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SteddagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new SteddagrCheckExist(option);
	}
	
	
	
	@Override protected SteddagrInfo toForwardClass(SteddInfo baseRecord) {
		return SteddagrInfo.copyFrom(baseRecord);
	}
}
