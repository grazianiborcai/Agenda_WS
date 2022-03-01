package br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.checker.SowalagrCheckExist;

public final class SowalCheckSowalagr extends ModelCheckerTemplateForward<SowalInfo, SowalagrInfo> {
	
	public SowalCheckSowalagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowalagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowalagrCheckExist(option);
	}
	
	
	
	@Override protected SowalagrInfo toForwardClass(SowalInfo baseRecord) {
		return SowalagrInfo.copyFrom(baseRecord);
	}
}
