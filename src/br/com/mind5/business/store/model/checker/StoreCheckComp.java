package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.checker.CompCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoreCheckComp extends ModelCheckerTemplateForward<StoreInfo, CompInfo> {
	
	public StoreCheckComp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CompInfo> getCheckerHook(ModelCheckerOption option) {
		return new CompCheckExist(option);
	}
	
	
	
	@Override protected CompInfo toForwardClass(StoreInfo baseRecord) {
		return CompInfo.copyFrom(baseRecord);
	}
}
