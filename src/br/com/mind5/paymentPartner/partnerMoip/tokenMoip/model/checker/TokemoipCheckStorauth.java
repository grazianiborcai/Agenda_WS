package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckStorauth extends ModelCheckerTemplateForward<TokemoipInfo, StorauthInfo> {
	
	public TokemoipCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(TokemoipInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
