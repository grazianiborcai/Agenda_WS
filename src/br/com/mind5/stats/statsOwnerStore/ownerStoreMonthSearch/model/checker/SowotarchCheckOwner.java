package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

public final class SowotarchCheckOwner extends ModelCheckerTemplateForward<SowotarchInfo, OwnerInfo> {
	
	public SowotarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SowotarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
