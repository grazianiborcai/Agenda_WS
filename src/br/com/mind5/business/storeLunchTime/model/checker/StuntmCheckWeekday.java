package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.checker.WeekdayCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StuntmCheckWeekday extends ModelCheckerTemplateForward<StuntmInfo, WeekdayInfo> {
	
	public StuntmCheckWeekday(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<WeekdayInfo> getCheckerHook(ModelCheckerOption option) {
		return new WeekdayCheckExist(option);
	}
	
	
	
	@Override protected WeekdayInfo toForwardClass(StuntmInfo baseRecord) {
		return WeekdayInfo.copyFrom(baseRecord);
	}
}
