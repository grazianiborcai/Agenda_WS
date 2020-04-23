package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchCopier;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckStolarch extends ModelCheckerTemplateForwardV2<StoreInfo, StolarchInfo> {
	
	public StoreCheckStolarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StolarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StolarchCheckExist(option);
	}
	
	
	
	@Override protected StolarchInfo toForwardClass(StoreInfo baseRecord) {
		return StolarchCopier.copyFromStore(baseRecord);
	}
}
