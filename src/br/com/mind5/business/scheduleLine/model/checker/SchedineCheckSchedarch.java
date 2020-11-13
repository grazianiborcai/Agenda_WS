package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedineCheckSchedarch extends ModelCheckerTemplateForward<SchedineInfo, SchedarchInfo> {
	
	public SchedineCheckSchedarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchedarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedarchCheckExist(option);
	}
	
	
	
	@Override protected SchedarchInfo toForwardClass(SchedineInfo baseRecord) {
		return SchedarchInfo.copyFrom(baseRecord);
	}
}
