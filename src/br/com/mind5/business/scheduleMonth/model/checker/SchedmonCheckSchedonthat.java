package br.com.mind5.business.scheduleMonth.model.checker;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.checker.SchedonthatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedmonCheckSchedonthat extends ModelCheckerTemplateForward<SchedmonInfo, SchedonthatInfo> {
	
	public SchedmonCheckSchedonthat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchedonthatInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedonthatCheckExist(option);
	}
	
	
	
	@Override protected SchedonthatInfo toForwardClass(SchedmonInfo baseRecord) {
		return SchedonthatInfo.copyFrom(baseRecord);
	}
}
