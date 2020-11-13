package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckSetupar extends ModelCheckerTemplateForward<AccemoipInfo, SetuparInfo> {
	
	public AccemoipCheckSetupar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SetuparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SetuparCheckExist(option);
	}
	
	
	
	@Override protected SetuparInfo toForwardClass(AccemoipInfo baseRecord) {
		return SetuparInfo.copyFrom(baseRecord);
	}
}
