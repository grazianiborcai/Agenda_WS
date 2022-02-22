package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StedmonagrCheckLangu extends ModelCheckerTemplateForward<StedmonagrInfo, LanguInfo> {
	
	public StedmonagrCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StedmonagrInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
