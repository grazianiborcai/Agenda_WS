package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StedmonagrCheckStore extends ModelCheckerTemplateForward<StedmonagrInfo, StoreInfo> {
	
	public StedmonagrCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(StedmonagrInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
