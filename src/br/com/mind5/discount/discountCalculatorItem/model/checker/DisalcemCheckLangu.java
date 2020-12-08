package br.com.mind5.discount.discountCalculatorItem.model.checker;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class DisalcemCheckLangu extends ModelCheckerTemplateForward<DisalcemInfo, LanguInfo> {
	
	public DisalcemCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(DisalcemInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
