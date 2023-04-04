package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;

public final class SplitapaCheckPayordem extends ModelCheckerTemplateForward<SplitapaInfo, PayordemInfo> {
	
	public SplitapaCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(SplitapaInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
