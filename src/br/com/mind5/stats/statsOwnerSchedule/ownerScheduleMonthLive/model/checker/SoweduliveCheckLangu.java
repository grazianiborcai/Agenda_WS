package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class SoweduliveCheckLangu extends ModelCheckerTemplateForward<SoweduliveInfo, LanguInfo> {
	
	public SoweduliveCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SoweduliveInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
