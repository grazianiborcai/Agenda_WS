package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;

public final class CustopaCheckSetupar extends ModelCheckerTemplateForward<CustopaInfo, SetuparInfo> {
	
	public CustopaCheckSetupar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SetuparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SetuparCheckExist(option);
	}
	
	
	
	@Override protected SetuparInfo toForwardClass(CustopaInfo baseRecord) {
		return SetuparInfo.copyFrom(baseRecord);
	}
}
