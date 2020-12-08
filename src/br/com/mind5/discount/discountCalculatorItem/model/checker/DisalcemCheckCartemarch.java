package br.com.mind5.discount.discountCalculatorItem.model.checker;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.checker.CartemarchCheckExistUser;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class DisalcemCheckCartemarch extends ModelCheckerTemplateForward<DisalcemInfo, CartemarchInfo> {
	
	public DisalcemCheckCartemarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CartemarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartemarchCheckExistUser(option);
	}
	
	
	
	@Override protected CartemarchInfo toForwardClass(DisalcemInfo baseRecord) {
		return CartemarchInfo.copyFrom(baseRecord);
	}
}
