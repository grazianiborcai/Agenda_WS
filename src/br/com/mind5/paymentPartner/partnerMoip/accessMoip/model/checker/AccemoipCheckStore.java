package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckStore extends ModelCheckerTemplateForward<AccemoipInfo, StoreInfo> {
	
	public AccemoipCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(AccemoipInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
