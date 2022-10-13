package br.com.mind5.business.personLegal.model.checker;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PeregCheckStore extends ModelCheckerTemplateForward<PeregInfo, StoreInfo> {
	
	public PeregCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(PeregInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
