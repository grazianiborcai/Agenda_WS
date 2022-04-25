package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.checker.WeekdayCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplutmCheckWeekday extends ModelCheckerTemplateForward<EmplutmInfo, WeekdayInfo> {
	
	public EmplutmCheckWeekday(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<WeekdayInfo> getCheckerHook(ModelCheckerOption option) {
		return new WeekdayCheckExist(option);
	}
	
	
	
	@Override protected WeekdayInfo toForwardClass(EmplutmInfo baseRecord) {
		return WeekdayInfo.copyFrom(baseRecord);
	}
}
