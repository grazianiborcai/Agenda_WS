package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker.StefiloniveCheckExist;

public final class StefilonCheckStefilonive extends ModelCheckerTemplateForward<StefilonInfo, StefiloniveInfo> {
	
	public StefilonCheckStefilonive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StefiloniveInfo> getCheckerHook(ModelCheckerOption option) {
		return new StefiloniveCheckExist(option);
	}
	
	
	
	@Override protected StefiloniveInfo toForwardClass(StefilonInfo baseRecord) {
		return StefiloniveInfo.copyFrom(baseRecord);
	}
}
