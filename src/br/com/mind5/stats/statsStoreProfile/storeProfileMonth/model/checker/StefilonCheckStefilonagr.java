package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.checker.StefilonagrCheckExist;

public final class StefilonCheckStefilonagr extends ModelCheckerTemplateForward<StefilonInfo, StefilonagrInfo> {
	
	public StefilonCheckStefilonagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StefilonagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new StefilonagrCheckExist(option);
	}
	
	
	
	@Override protected StefilonagrInfo toForwardClass(StefilonInfo baseRecord) {
		return StefilonagrInfo.copyFrom(baseRecord);
	}
}
