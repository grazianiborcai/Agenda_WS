package br.com.mind5.business.employeeLeaveDateRange.model.checker;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmplargCheckStore extends ModelCheckerTemplateForwardV2<EmplargInfo, StoreInfo> {
	
	public EmplargCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(EmplargInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
