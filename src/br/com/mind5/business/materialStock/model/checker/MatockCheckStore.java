package br.com.mind5.business.materialStock.model.checker;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatockCheckStore extends ModelCheckerTemplateForwardV2<MatockInfo, StoreInfo> {
	
	public MatockCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(MatockInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
