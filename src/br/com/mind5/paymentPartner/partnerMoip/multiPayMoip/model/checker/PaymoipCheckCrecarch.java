package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.creditCardSearch.info.CrecarchCopier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckCrecarch extends ModelCheckerTemplateForward<PaymoipInfo, CrecarchInfo> {
	
	public PaymoipCheckCrecarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CrecarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CrecarchCheckExist(option);
	}
	
	
	
	@Override protected CrecarchInfo toForwardClass(PaymoipInfo baseRecord) {
		return CrecarchCopier.copyFromPaymoip(baseRecord);
	}
}
