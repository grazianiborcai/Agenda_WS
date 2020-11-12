package br.com.mind5.business.scheduleRange.model.checker;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedageCheckStore extends ModelCheckerTemplateForwardV2<SchedageInfo, StoreInfo> {
	
	public SchedageCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(SchedageInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
