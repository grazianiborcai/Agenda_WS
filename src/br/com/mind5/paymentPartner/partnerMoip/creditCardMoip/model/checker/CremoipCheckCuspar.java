package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckCuspar extends ModelCheckerTemplateForward<CremoipInfo, CusparInfo> {
	
	public CremoipCheckCuspar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusparInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusparCheckExist(option);
	}
	
	
	
	@Override protected CusparInfo toForwardClass(CremoipInfo baseRecord) {
		return CusparInfo.copyFrom(baseRecord);
	}
}
