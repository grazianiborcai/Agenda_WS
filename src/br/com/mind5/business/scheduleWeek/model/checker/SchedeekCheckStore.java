package br.com.mind5.business.scheduleWeek.model.checker;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedeekCheckStore extends ModelCheckerTemplateForwardV2<SchedeekInfo, StoreInfo> {
	
	public SchedeekCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(SchedeekInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
