package br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowaliveCheckExist;

public final class SowalCheckSowordive extends ModelCheckerTemplateForward<SowalInfo, SowaliveInfo> {
	
	public SowalCheckSowordive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowaliveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowaliveCheckExist(option);
	}
	
	
	
	@Override protected SowaliveInfo toForwardClass(SowalInfo baseRecord) {
		return SowaliveInfo.copyFrom(baseRecord);
	}
}
