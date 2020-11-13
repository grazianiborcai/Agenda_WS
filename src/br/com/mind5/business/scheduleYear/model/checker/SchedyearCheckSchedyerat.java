package br.com.mind5.business.scheduleYear.model.checker;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.model.checker.SchedyeratCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedyearCheckSchedyerat extends ModelCheckerTemplateForward<SchedyearInfo, SchedyeratInfo> {
	
	public SchedyearCheckSchedyerat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchedyeratInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedyeratCheckExist(option);
	}
	
	
	
	@Override protected SchedyeratInfo toForwardClass(SchedyearInfo baseRecord) {
		return SchedyeratInfo.copyFrom(baseRecord);
	}
}
