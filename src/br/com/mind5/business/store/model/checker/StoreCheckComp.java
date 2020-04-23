package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.checker.CompCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckComp extends ModelCheckerTemplateForwardV2<StoreInfo, CompInfo> {
	
	public StoreCheckComp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CompInfo> getCheckerHook(ModelCheckerOption option) {
		return new CompCheckExist(option);
	}
	
	
	
	@Override protected CompInfo toForwardClass(StoreInfo baseRecord) {
		return CompInfo.copyFrom(baseRecord);
	}
}
