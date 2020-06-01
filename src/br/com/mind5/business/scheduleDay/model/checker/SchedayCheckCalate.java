package br.com.mind5.business.scheduleDay.model.checker;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.checker.CalateCheckExist;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedayCheckCalate extends ModelCheckerTemplateForwardV2<SchedayInfo, CalateInfo> {
	
	public SchedayCheckCalate(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CalateInfo> getCheckerHook(ModelCheckerOption option) {
		return new CalateCheckExist(option);
	}
	
	
	
	@Override protected CalateInfo toForwardClass(SchedayInfo baseRecord) {
		return CalateInfo.copyFrom(baseRecord);
	}
}
