package br.com.mind5.business.scheduleYear.model.checker;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedyearCheckStore extends ModelCheckerTemplateForward<SchedyearInfo, StoreInfo> {
	
	public SchedyearCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(SchedyearInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
