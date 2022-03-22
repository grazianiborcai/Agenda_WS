package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

public final class CutefiloniveCheckCus extends ModelCheckerTemplateForward<CutefiloniveInfo, CusInfo> {
	
	public CutefiloniveCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(CutefiloniveInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
