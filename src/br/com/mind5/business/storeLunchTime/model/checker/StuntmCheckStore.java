package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StuntmCheckStore extends ModelCheckerTemplateForward<StuntmInfo, StoreInfo> {
	
	public StuntmCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(StuntmInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
