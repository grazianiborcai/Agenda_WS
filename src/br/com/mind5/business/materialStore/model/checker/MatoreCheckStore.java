package br.com.mind5.business.materialStore.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatoreCheckStore extends ModelCheckerTemplateForwardV2<MatoreInfo, StoreInfo> {
	
	public MatoreCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(MatoreInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
