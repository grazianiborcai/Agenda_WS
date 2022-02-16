package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.checker.SteddiveCheckExist;

public final class SteddCheckSteddive extends ModelCheckerTemplateForward<SteddInfo, SteddiveInfo> {
	
	public SteddCheckSteddive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SteddiveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SteddiveCheckExist(option);
	}
	
	
	
	@Override protected SteddiveInfo toForwardClass(SteddInfo baseRecord) {
		return SteddiveInfo.copyFrom(baseRecord);
	}
}
