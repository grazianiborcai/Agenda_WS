package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckPayordem extends ModelCheckerTemplateForwardV2<OrdmoipInfo, PayordemInfo> {
	
	public OrdmoipCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(OrdmoipInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
