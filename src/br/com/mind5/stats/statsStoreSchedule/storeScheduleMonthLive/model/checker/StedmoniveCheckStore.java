package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StedmoniveCheckStore extends ModelCheckerTemplateForward<StedmoniveInfo, StoreInfo> {
	
	public StedmoniveCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(StedmoniveInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
