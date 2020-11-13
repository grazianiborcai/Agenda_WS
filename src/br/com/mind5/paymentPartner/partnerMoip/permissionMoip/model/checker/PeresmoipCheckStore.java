package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckStore extends ModelCheckerTemplateForward<PeresmoipInfo, StoreInfo> {
	
	public PeresmoipCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(PeresmoipInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
