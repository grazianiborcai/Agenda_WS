package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;

public final class SplitapaCheckPayord extends ModelCheckerTemplateForward<SplitapaInfo, PayordInfo> {
	
	public SplitapaCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(SplitapaInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
