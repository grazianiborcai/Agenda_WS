package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;

public final class SowusCheckOwner extends ModelCheckerTemplateForward<SowusInfo, OwnerInfo> {
	
	public SowusCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SowusInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
