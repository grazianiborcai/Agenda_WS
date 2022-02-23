package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckExist;

public final class StoronCheckStoronagr extends ModelCheckerTemplateForward<StoronInfo, StoronagrInfo> {
	
	public StoronCheckStoronagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoronagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoronagrCheckExist(option);
	}
	
	
	
	@Override protected StoronagrInfo toForwardClass(StoronInfo baseRecord) {
		return StoronagrInfo.copyFrom(baseRecord);
	}
}
