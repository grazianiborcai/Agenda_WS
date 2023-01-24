package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.checker.PayparCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckPaypar extends ModelCheckerTemplateForward<CrecardInfo, PayparInfo> {
	
	public CrecardCheckPaypar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayparInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayparCheckExist(option);
	}
	
	
	
	@Override protected PayparInfo toForwardClass(CrecardInfo baseRecord) {
		return PayparInfo.copyFrom(baseRecord);
	}
}
