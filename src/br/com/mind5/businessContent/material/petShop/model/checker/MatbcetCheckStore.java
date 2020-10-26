package br.com.mind5.businessContent.material.petShop.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatbcetCheckStore extends ModelCheckerTemplateForwardV2<MatbcetInfo, StoreInfo> {
	
	public MatbcetCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(MatbcetInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
