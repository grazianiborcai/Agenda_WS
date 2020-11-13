package br.com.mind5.authorization.scheduleAuthorization.model.checker;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedauthCheckSchedine extends ModelCheckerTemplateForward<SchedauthInfo, SchedineInfo> {
	
	public SchedauthCheckSchedine(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchedineInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedineCheckExist(option);
	}
	
	
	
	@Override protected SchedineInfo toForwardClass(SchedauthInfo baseRecord) {
		return SchedineInfo.copyFrom(baseRecord);
	}
}
