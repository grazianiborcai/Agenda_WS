package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;

public final class StefiloniveCheckOwner extends ModelCheckerTemplateForward<StefiloniveInfo, OwnerInfo> {
	
	public StefiloniveCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StefiloniveInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
