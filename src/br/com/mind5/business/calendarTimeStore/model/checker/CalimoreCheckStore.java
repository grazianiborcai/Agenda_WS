package br.com.mind5.business.calendarTimeStore.model.checker;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CalimoreCheckStore extends ModelCheckerTemplateForward<CalimoreInfo, StoreInfo> {
	
	public CalimoreCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(CalimoreInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
