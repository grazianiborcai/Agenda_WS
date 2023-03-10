package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.checker.PayparCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckPaypar extends ModelCheckerTemplateForward<PayordInfo, PayparInfo> {
	
	public PayordCheckPaypar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayparInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayparCheckExist(option);
	}
	
	
	
	@Override protected PayparInfo toForwardClass(PayordInfo baseRecord) {
		return PayparInfo.copyFrom(baseRecord);
	}
}
