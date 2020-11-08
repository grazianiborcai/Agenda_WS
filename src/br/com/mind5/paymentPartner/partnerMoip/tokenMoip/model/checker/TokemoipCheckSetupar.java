package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckSetupar extends ModelCheckerTemplateForwardV2<TokemoipInfo, SetuparInfo> {
	
	public TokemoipCheckSetupar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SetuparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SetuparCheckExist(option);
	}
	
	
	
	@Override protected SetuparInfo toForwardClass(TokemoipInfo baseRecord) {
		return SetuparInfo.copyFrom(baseRecord);
	}
}
