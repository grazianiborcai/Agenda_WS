package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckExist;

public final class SowedulCheckSowedulagr extends ModelCheckerTemplateForward<SowedulInfo, SowedulagrInfo> {
	
	public SowedulCheckSowedulagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowedulagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowedulagrCheckExist(option);
	}
	
	
	
	@Override protected SowedulagrInfo toForwardClass(SowedulInfo baseRecord) {
		return SowedulagrInfo.copyFrom(baseRecord);
	}
}
