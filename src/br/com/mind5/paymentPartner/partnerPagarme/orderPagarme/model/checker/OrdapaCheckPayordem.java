package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;

public final class OrdapaCheckPayordem extends ModelCheckerTemplateForward<OrdapaInfo, PayordemInfo> {
	
	public OrdapaCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(OrdapaInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
