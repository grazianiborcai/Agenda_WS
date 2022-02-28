package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker.SoweduliveCheckExist;

public final class SowedulCheckSowedulive extends ModelCheckerTemplateForward<SowedulInfo, SoweduliveInfo> {
	
	public SowedulCheckSowedulive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SoweduliveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SoweduliveCheckExist(option);
	}
	
	
	
	@Override protected SoweduliveInfo toForwardClass(SowedulInfo baseRecord) {
		return SoweduliveInfo.copyFrom(baseRecord);
	}
}
