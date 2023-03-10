package br.com.mind5.payment.payOrderItem.model.checker;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.checker.PayparCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckPaypar extends ModelCheckerTemplateForward<PayordemInfo, PayparInfo> {
	
	public PayordemCheckPaypar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayparInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayparCheckExist(option);
	}
	
	
	
	@Override protected PayparInfo toForwardClass(PayordemInfo baseRecord) {
		return PayparInfo.copyFrom(baseRecord);
	}
}
