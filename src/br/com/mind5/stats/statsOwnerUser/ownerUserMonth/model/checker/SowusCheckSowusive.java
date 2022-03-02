package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.checker.SowusiveCheckExist;

public final class SowusCheckSowusive extends ModelCheckerTemplateForward<SowusInfo, SowusiveInfo> {
	
	public SowusCheckSowusive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowusiveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowusiveCheckExist(option);
	}
	
	
	
	@Override protected SowusiveInfo toForwardClass(SowusInfo baseRecord) {
		return SowusiveInfo.copyFrom(baseRecord);
	}
}
