package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.creditCardSearch.info.CrecarchCopier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckCrecarch extends ModelCheckerTemplateForwardV2<PaymoipInfo, CrecarchInfo> {
	
	public PaymoipCheckCrecarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CrecarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CrecarchCheckExist(option);
	}
	
	
	
	@Override protected CrecarchInfo toForwardClass(PaymoipInfo baseRecord) {
		return CrecarchCopier.copyFromPaymoip(baseRecord);
	}
}
