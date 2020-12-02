package br.com.mind5.discount.discountStore.model.checker;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class DisoreCheckLangu extends ModelCheckerTemplateForward<DisoreInfo, LanguInfo> {
	
	public DisoreCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(DisoreInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
