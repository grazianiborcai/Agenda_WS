package br.com.mind5.business.calendarTimeStore.model.checker;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CalimoreCheckStowotarch extends ModelCheckerTemplateForward<CalimoreInfo, StowotarchInfo> {
	
	public CalimoreCheckStowotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StowotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StowotarchCheckExist(option);
	}
	
	
	
	@Override protected StowotarchInfo toForwardClass(CalimoreInfo baseRecord) {
		return StowotarchInfo.copyFrom(baseRecord);
	}
}
