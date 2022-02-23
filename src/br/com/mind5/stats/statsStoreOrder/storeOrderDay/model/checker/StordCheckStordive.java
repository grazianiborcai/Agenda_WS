package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckExist;

public final class StordCheckStordive extends ModelCheckerTemplateForward<StordInfo, StordiveInfo> {
	
	public StordCheckStordive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StordiveInfo> getCheckerHook(ModelCheckerOption option) {
		return new StordiveCheckExist(option);
	}
	
	
	
	@Override protected StordiveInfo toForwardClass(StordInfo baseRecord) {
		return StordiveInfo.copyFrom(baseRecord);
	}
}
