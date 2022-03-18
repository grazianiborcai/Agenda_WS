package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;

public final class StefiloniveCheckStore extends ModelCheckerTemplateForward<StefiloniveInfo, StoreInfo> {
	
	public StefiloniveCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(StefiloniveInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
