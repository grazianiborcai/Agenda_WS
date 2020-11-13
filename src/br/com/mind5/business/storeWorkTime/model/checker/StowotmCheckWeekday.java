package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.checker.WeekdayCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StowotmCheckWeekday extends ModelCheckerTemplateForward<StowotmInfo, WeekdayInfo> {
	
	public StowotmCheckWeekday(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<WeekdayInfo> getCheckerHook(ModelCheckerOption option) {
		return new WeekdayCheckExist(option);
	}
	
	
	
	@Override protected WeekdayInfo toForwardClass(StowotmInfo baseRecord) {
		return WeekdayInfo.copyFrom(baseRecord);
	}
}
