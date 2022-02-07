package br.com.mind5.stats.statsOwnerUser.ownerUserLive.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;

public final class SowusiveCheckOwner extends ModelCheckerTemplateForward<SowusiveInfo, OwnerInfo> {
	
	public SowusiveCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SowusiveInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
