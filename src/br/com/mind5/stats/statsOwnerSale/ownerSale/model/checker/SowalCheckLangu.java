package br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;

public final class SowalCheckLangu extends ModelCheckerTemplateForward<SowalInfo, LanguInfo> {
	
	public SowalCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SowalInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
