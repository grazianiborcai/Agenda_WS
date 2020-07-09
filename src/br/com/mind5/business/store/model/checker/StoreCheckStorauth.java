package br.com.mind5.business.store.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthorization;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckStorauth extends ModelCheckerTemplateForwardV2<StoreInfo, StorauthInfo> {
	
	public StoreCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckAuthorization(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(StoreInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
