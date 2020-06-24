package br.com.mind5.business.scheduleAuthorization.model.checker;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedauthCheckSchedine extends ModelCheckerTemplateForwardV2<SchedauthInfo, SchedineInfo> {
	
	public SchedauthCheckSchedine(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchedineInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedineCheckExist(option);
	}
	
	
	
	@Override protected SchedineInfo toForwardClass(SchedauthInfo baseRecord) {
		return SchedineInfo.copyFrom(baseRecord);
	}
}
