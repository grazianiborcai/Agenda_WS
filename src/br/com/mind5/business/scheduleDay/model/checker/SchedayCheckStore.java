package br.com.mind5.business.scheduleDay.model.checker;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedayCheckStore extends ModelCheckerTemplateForwardV2<SchedayInfo, StoreInfo> {
	
	public SchedayCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(SchedayInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
