package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

public final class CutefiloniveCheckSytotin extends ModelCheckerTemplateForward<CutefiloniveInfo, SytotinInfo> {
	
	public CutefiloniveCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(CutefiloniveInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
