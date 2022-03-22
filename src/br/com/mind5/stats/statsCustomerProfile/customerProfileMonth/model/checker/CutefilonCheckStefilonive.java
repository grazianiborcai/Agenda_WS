package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker.CutefiloniveCheckExist;

public final class CutefilonCheckStefilonive extends ModelCheckerTemplateForward<CutefilonInfo, CutefiloniveInfo> {
	
	public CutefilonCheckStefilonive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CutefiloniveInfo> getCheckerHook(ModelCheckerOption option) {
		return new CutefiloniveCheckExist(option);
	}
	
	
	
	@Override protected CutefiloniveInfo toForwardClass(CutefilonInfo baseRecord) {
		return CutefiloniveInfo.copyFrom(baseRecord);
	}
}
