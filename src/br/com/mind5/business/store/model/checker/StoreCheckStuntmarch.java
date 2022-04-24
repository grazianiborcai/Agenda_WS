package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.model.checker.StuntmarchCheckExistStore;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class StoreCheckStuntmarch extends ModelCheckerTemplateForward<StoreInfo, StuntmarchInfo> {
	
	public StoreCheckStuntmarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StuntmarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StuntmarchCheckExistStore(option);
	}
	
	
	
	@Override protected StuntmarchInfo toForwardClass(StoreInfo baseRecord) {
		return StuntmarchInfo.copyFrom(baseRecord);
	}
}
