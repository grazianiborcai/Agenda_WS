package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedineCheckSchedarch extends ModelCheckerTemplateForwardV2<SchedineInfo, SchedarchInfo> {
	
	public SchedineCheckSchedarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchedarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedarchCheckExist(option);
	}
	
	
	
	@Override protected SchedarchInfo toForwardClass(SchedineInfo baseRecord) {
		return SchedarchInfo.copyFrom(baseRecord);
	}
}
