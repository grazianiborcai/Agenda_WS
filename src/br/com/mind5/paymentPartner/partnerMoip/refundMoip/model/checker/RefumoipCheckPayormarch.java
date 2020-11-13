package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderSearch.info.PayordarchCopier;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckPayormarch extends ModelCheckerTemplateForward<RefumoipInfo, PayordarchInfo> {
	
	public RefumoipCheckPayormarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordarchCheckExist(option);
	}
	
	
	
	@Override protected PayordarchInfo toForwardClass(RefumoipInfo baseRecord) {
		return PayordarchCopier.copyFromRefumoip(baseRecord);
	}
}
