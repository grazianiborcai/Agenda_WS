package br.com.mind5.stats.statsOwnerStore.ownerStore.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.checker.SowotiveCheckExist;

public final class SowotCheckSowotive extends ModelCheckerTemplateForward<SowotInfo, SowotiveInfo> {
	
	public SowotCheckSowotive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowotiveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowotiveCheckExist(option);
	}
	
	
	
	@Override protected SowotiveInfo toForwardClass(SowotInfo baseRecord) {
		return SowotiveInfo.copyFrom(baseRecord);
	}
}
