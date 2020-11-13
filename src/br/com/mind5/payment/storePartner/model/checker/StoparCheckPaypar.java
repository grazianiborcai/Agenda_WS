package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.checker.PayparCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckPaypar extends ModelCheckerTemplateForward<StoparInfo, PayparInfo> {
	
	public StoparCheckPaypar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayparInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayparCheckExist(option);
	}
	
	
	
	@Override protected PayparInfo toForwardClass(StoparInfo baseRecord) {
		return PayparInfo.copyFrom(baseRecord);
	}
}
