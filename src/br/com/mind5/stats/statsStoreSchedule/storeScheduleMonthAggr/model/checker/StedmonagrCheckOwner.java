package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StedmonagrCheckOwner extends ModelCheckerTemplateForward<StedmonagrInfo, OwnerInfo> {
	
	public StedmonagrCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StedmonagrInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
