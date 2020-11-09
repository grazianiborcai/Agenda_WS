package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckSetupar extends ModelCheckerTemplateForwardV2<AccemoipInfo, SetuparInfo> {
	
	public AccemoipCheckSetupar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SetuparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SetuparCheckExist(option);
	}
	
	
	
	@Override protected SetuparInfo toForwardClass(AccemoipInfo baseRecord) {
		return SetuparInfo.copyFrom(baseRecord);
	}
}
