package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker.SowotagrCheckExist;

public final class SowotCheckSowotagr extends ModelCheckerTemplateForward<SowotInfo, SowotagrInfo> {
	
	public SowotCheckSowotagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowotagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowotagrCheckExist(option);
	}
	
	
	
	@Override protected SowotagrInfo toForwardClass(SowotInfo baseRecord) {
		return SowotagrInfo.copyFrom(baseRecord);
	}
}
