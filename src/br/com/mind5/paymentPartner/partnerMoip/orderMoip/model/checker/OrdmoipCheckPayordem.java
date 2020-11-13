package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckPayordem extends ModelCheckerTemplateForward<OrdmoipInfo, PayordemInfo> {
	
	public OrdmoipCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(OrdmoipInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
