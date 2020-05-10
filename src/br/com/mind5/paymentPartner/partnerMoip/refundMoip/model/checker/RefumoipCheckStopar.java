package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckStopar extends ModelCheckerTemplateForwardV2<RefumoipInfo, StoparInfo> {
	
	public RefumoipCheckStopar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoparInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoparCheckExist(option);
	}
	
	
	
	@Override protected StoparInfo toForwardClass(RefumoipInfo baseRecord) {
		return StoparInfo.copyFrom(baseRecord);
	}
}
