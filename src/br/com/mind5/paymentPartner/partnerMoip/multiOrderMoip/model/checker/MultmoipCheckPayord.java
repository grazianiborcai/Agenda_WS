package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckPayord extends ModelCheckerTemplateForward<MultmoipInfo, PayordInfo> {
	
	public MultmoipCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(MultmoipInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
