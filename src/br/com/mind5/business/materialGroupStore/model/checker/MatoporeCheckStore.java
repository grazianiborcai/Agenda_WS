package br.com.mind5.business.materialGroupStore.model.checker;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatoporeCheckStore extends ModelCheckerTemplateForwardV2<MatoporeInfo, StoreInfo> {
	
	public MatoporeCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(MatoporeInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
