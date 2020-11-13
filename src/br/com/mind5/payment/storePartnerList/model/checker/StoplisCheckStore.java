package br.com.mind5.payment.storePartnerList.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisCheckStore extends ModelCheckerTemplateForward<StoplisInfo, StoreInfo> {
	
	public StoplisCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(StoplisInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
