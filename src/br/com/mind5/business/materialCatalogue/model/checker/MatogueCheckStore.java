package br.com.mind5.business.materialCatalogue.model.checker;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatogueCheckStore extends ModelCheckerTemplateForward<MatogueInfo, StoreInfo> {
	
	public MatogueCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(MatogueInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
