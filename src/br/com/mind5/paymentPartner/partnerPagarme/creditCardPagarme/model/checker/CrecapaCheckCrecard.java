package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;

public final class CrecapaCheckCrecard extends ModelCheckerTemplateForward<CrecapaInfo, CrecardInfo> {
	
	public CrecapaCheckCrecard(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CrecardInfo> getCheckerHook(ModelCheckerOption option) {
		return new CrecardCheckExist(option);
	}
	
	
	
	@Override protected CrecardInfo toForwardClass(CrecapaInfo baseRecord) {
		return CrecardInfo.copyFrom(baseRecord);
	}
}
