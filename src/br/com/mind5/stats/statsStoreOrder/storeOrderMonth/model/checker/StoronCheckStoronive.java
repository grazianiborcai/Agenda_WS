package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckExist;

public final class StoronCheckStoronive extends ModelCheckerTemplateForward<StoronInfo, StoroniveInfo> {
	
	public StoronCheckStoronive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoroniveInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoroniveCheckExist(option);
	}
	
	
	
	@Override protected StoroniveInfo toForwardClass(StoronInfo baseRecord) {
		return StoroniveInfo.copyFrom(baseRecord);
	}
}
