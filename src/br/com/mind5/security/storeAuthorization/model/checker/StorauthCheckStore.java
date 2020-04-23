package br.com.mind5.security.storeAuthorization.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StorauthCheckStore extends ModelCheckerTemplateForwardV2<StorauthInfo, StoreInfo> {
	
	public StorauthCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(StorauthInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
