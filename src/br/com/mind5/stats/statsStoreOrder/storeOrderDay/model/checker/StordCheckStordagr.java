package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckExist;

public final class StordCheckStordagr extends ModelCheckerTemplateForward<StordInfo, StordagrInfo> {
	
	public StordCheckStordagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StordagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new StordagrCheckExist(option);
	}
	
	
	
	@Override protected StordagrInfo toForwardClass(StordInfo baseRecord) {
		return StordagrInfo.copyFrom(baseRecord);
	}
}
