package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;

public final class RecipaCheckStore extends ModelCheckerTemplateForward<RecipaInfo, StoreInfo> {
	
	public RecipaCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(RecipaInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
