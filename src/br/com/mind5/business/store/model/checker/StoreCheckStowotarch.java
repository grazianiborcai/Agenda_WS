package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoreCheckStowotarch extends ModelCheckerTemplateForward<StoreInfo, StowotarchInfo> {
	
	public StoreCheckStowotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StowotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StowotarchCheckExist(option);
	}
	
	
	
	@Override protected StowotarchInfo toForwardClass(StoreInfo baseRecord) {
		return StowotarchInfo.copyFrom(baseRecord);
	}
}
