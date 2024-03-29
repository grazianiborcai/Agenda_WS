package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

public final class CustamonagrCheckCus extends ModelCheckerTemplateForward<CustamonagrInfo, CusInfo> {
	
	public CustamonagrCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(CustamonagrInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
