package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckPayord extends ModelCheckerTemplateForwardV2<OrdmoipInfo, PayordInfo> {
	
	public OrdmoipCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(OrdmoipInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
