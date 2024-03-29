package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class SoweduliveCheckOwner extends ModelCheckerTemplateForward<SoweduliveInfo, OwnerInfo> {
	
	public SoweduliveCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SoweduliveInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
