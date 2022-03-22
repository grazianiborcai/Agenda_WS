package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker.CustamoniveCheckExist;

public final class CustamonCheckCustamonive extends ModelCheckerTemplateForward<CustamonInfo, CustamoniveInfo> {
	
	public CustamonCheckCustamonive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CustamoniveInfo> getCheckerHook(ModelCheckerOption option) {
		return new CustamoniveCheckExist(option);
	}
	
	
	
	@Override protected CustamoniveInfo toForwardClass(CustamonInfo baseRecord) {
		return CustamoniveInfo.copyFrom(baseRecord);
	}
}
