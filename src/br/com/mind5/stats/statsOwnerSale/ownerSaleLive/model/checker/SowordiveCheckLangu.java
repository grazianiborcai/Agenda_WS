package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

public final class SowordiveCheckLangu extends ModelCheckerTemplateForward<SowaliveInfo, LanguInfo> {
	
	public SowordiveCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SowaliveInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
