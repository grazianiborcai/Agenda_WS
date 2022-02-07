package br.com.mind5.stats.statsOwnerStore.ownerStore.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsOwnerStore.storeAccountLive.model.checker.StoraciveCheckExist;

public final class SowotCheckStoracive extends ModelCheckerTemplateForward<SowotInfo, StoraciveInfo> {
	
	public SowotCheckStoracive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoraciveInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoraciveCheckExist(option);
	}
	
	
	
	@Override protected StoraciveInfo toForwardClass(SowotInfo baseRecord) {
		return StoraciveInfo.copyFrom(baseRecord);
	}
}
