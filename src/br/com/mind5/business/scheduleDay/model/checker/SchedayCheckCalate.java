package br.com.mind5.business.scheduleDay.model.checker;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.checker.CalateCheckExist;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedayCheckCalate extends ModelCheckerTemplateForward<SchedayInfo, CalateInfo> {
	
	public SchedayCheckCalate(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CalateInfo> getCheckerHook(ModelCheckerOption option) {
		return new CalateCheckExist(option);
	}
	
	
	
	@Override protected CalateInfo toForwardClass(SchedayInfo baseRecord) {
		return CalateInfo.copyFrom(baseRecord);
	}
}
