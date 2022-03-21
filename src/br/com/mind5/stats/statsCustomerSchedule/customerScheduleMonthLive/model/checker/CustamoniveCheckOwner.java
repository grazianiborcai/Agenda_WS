package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;

public final class CustamoniveCheckOwner extends ModelCheckerTemplateForward<CustamoniveInfo, OwnerInfo> {
	
	public CustamoniveCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CustamoniveInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
