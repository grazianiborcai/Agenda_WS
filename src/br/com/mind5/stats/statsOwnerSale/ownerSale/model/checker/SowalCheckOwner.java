package br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;

public final class SowalCheckOwner extends ModelCheckerTemplateForward<SowalInfo, OwnerInfo> {
	
	public SowalCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SowalInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
