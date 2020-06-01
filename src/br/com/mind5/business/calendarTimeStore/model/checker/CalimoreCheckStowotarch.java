package br.com.mind5.business.calendarTimeStore.model.checker;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CalimoreCheckStowotarch extends ModelCheckerTemplateForwardV2<CalimoreInfo, StowotarchInfo> {
	
	public CalimoreCheckStowotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StowotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StowotarchCheckExist(option);
	}
	
	
	
	@Override protected StowotarchInfo toForwardClass(CalimoreInfo baseRecord) {
		return StowotarchInfo.copyFrom(baseRecord);
	}
}
