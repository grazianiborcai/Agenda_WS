package br.com.mind5.business.scheduleWeek.model.checker;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedeekCheckStore extends ModelCheckerTemplateForward<SchedeekInfo, StoreInfo> {
	
	public SchedeekCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(SchedeekInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
