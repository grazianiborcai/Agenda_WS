package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;

public final class SowotCheckOwner extends ModelCheckerTemplateForward<SowotInfo, OwnerInfo> {
	
	public SowotCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SowotInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
