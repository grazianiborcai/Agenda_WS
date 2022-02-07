package br.com.mind5.stats.statsOwnerUser.ownerUser.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.model.checker.SowusiveCheckExist;

public final class SowusCheckSuseracive extends ModelCheckerTemplateForward<SowusInfo, SowusiveInfo> {
	
	public SowusCheckSuseracive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowusiveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowusiveCheckExist(option);
	}
	
	
	
	@Override protected SowusiveInfo toForwardClass(SowusInfo baseRecord) {
		return SowusiveInfo.copyFrom(baseRecord);
	}
}
