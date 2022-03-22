package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker.CutefilonagrCheckExist;

public final class CutefilonCheckStefilonagr extends ModelCheckerTemplateForward<CutefilonInfo, CutefilonagrInfo> {
	
	public CutefilonCheckStefilonagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CutefilonagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new CutefilonagrCheckExist(option);
	}
	
	
	
	@Override protected CutefilonagrInfo toForwardClass(CutefilonInfo baseRecord) {
		return CutefilonagrInfo.copyFrom(baseRecord);
	}
}
