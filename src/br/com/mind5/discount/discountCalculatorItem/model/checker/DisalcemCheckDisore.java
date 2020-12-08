package br.com.mind5.discount.discountCalculatorItem.model.checker;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckExistValid;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class DisalcemCheckDisore extends ModelCheckerTemplateForward<DisalcemInfo, DisoreInfo> {
	
	public DisalcemCheckDisore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<DisoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new DisoreCheckExistValid(option);
	}
	
	
	
	@Override protected DisoreInfo toForwardClass(DisalcemInfo baseRecord) {
		return DisoreInfo.copyFrom(baseRecord);
	}
}
