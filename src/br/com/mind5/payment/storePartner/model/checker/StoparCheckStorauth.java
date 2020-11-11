package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckStorauth extends ModelCheckerTemplateForwardV2<StoparInfo, StorauthInfo> {
	
	public StoparCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(StoparInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
