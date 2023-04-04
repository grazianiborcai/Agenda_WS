package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;

public final class SplitapaCheckSetupar extends ModelCheckerTemplateForward<SplitapaInfo, SetuparInfo> {
	
	public SplitapaCheckSetupar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SetuparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SetuparCheckExist(option);
	}
	
	
	
	@Override protected SetuparInfo toForwardClass(SplitapaInfo baseRecord) {
		return SetuparInfo.copyFrom(baseRecord);
	}
}
