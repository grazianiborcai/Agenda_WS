package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker.CustamonagrCheckExist;

public final class CustamonCheckCustamonagr extends ModelCheckerTemplateForward<CustamonInfo, CustamonagrInfo> {
	
	public CustamonCheckCustamonagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CustamonagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new CustamonagrCheckExist(option);
	}
	
	
	
	@Override protected CustamonagrInfo toForwardClass(CustamonInfo baseRecord) {
		return CustamonagrInfo.copyFrom(baseRecord);
	}
}
