package br.com.mind5.business.scheduleDay.model.checker;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedayCheckSchedayta extends ModelCheckerTemplateForwardV2<SchedayInfo, SchedaytaInfo> {
	
	public SchedayCheckSchedayta(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchedaytaInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedaytaCheckExist(option);
	}
	
	
	
	@Override protected SchedaytaInfo toForwardClass(SchedayInfo baseRecord) {
		return SchedaytaInfo.copyFrom(baseRecord);
	}
}
