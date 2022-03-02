package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.checker.SowusagrCheckExist;

public final class SowusCheckSowusagr extends ModelCheckerTemplateForward<SowusInfo, SowusagrInfo> {
	
	public SowusCheckSowusagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowusagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowusagrCheckExist(option);
	}
	
	
	
	@Override protected SowusagrInfo toForwardClass(SowusInfo baseRecord) {
		return SowusagrInfo.copyFrom(baseRecord);
	}
}
