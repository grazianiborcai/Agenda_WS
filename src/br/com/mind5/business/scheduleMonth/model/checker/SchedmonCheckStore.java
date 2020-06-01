package br.com.mind5.business.scheduleMonth.model.checker;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedmonCheckStore extends ModelCheckerTemplateForwardV2<SchedmonInfo, StoreInfo> {
	
	public SchedmonCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(SchedmonInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
