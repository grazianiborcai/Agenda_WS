package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchCopier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.checker.PayormarchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckPayormarch extends ModelCheckerTemplateForward<MultmoipInfo, PayormarchInfo> {
	
	public MultmoipCheckPayormarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayormarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayormarchCheckExist(option);
	}
	
	
	
	@Override protected PayormarchInfo toForwardClass(MultmoipInfo baseRecord) {
		return PayormarchCopier.copyFromMultmoip(baseRecord);
	}
}
