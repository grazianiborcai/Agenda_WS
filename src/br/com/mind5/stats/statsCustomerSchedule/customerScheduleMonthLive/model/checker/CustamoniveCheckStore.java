package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;

public final class CustamoniveCheckStore extends ModelCheckerTemplateForward<CustamoniveInfo, StoreInfo> {
	
	public CustamoniveCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(CustamoniveInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
