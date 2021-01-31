package br.com.mind5.business.home.model.checker;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.checker.CartemCheckExistUser;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class HomeCheckCartem extends ModelCheckerTemplateForward<HomeInfo, CartemInfo> {
	
	public HomeCheckCartem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CartemInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartemCheckExistUser(option);
	}
	
	
	
	@Override protected CartemInfo toForwardClass(HomeInfo baseRecord) {
		return CartemInfo.copyFrom(baseRecord);
	}
}
