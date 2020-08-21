package br.com.mind5.business.materialCatalogue.model.checker;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatogueCheckStore extends ModelCheckerTemplateForwardV2<MatogueInfo, StoreInfo> {
	
	public MatogueCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(MatogueInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
