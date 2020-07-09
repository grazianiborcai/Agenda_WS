package br.com.mind5.authorization.customerAuthorization.model.checker;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CusauthCheckStore extends ModelCheckerTemplateForwardV2<CusauthInfo, StoreInfo> {
	
	public CusauthCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(CusauthInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
