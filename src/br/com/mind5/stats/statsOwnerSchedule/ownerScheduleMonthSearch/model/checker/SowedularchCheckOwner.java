package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;

public final class SowedularchCheckOwner extends ModelCheckerTemplateForward<SowedularchhInfo, OwnerInfo> {
	
	public SowedularchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SowedularchhInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
