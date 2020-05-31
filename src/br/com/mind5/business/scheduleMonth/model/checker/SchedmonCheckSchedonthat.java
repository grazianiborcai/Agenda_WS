package br.com.mind5.business.scheduleMonth.model.checker;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.checker.SchedonthatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedmonCheckSchedonthat extends ModelCheckerTemplateForwardV2<SchedmonInfo, SchedonthatInfo> {
	
	public SchedmonCheckSchedonthat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchedonthatInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedonthatCheckExist(option);
	}
	
	
	
	@Override protected SchedonthatInfo toForwardClass(SchedmonInfo baseRecord) {
		return SchedonthatInfo.copyFrom(baseRecord);
	}
}
