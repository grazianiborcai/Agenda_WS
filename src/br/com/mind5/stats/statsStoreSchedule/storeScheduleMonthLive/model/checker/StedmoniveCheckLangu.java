package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StedmoniveCheckLangu extends ModelCheckerTemplateForward<StedmoniveInfo, LanguInfo> {
	
	public StedmoniveCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StedmoniveInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
