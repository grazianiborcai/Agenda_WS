package br.com.mind5.business.cartCounter.model.checker;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.checker.CartemCheckExistUser;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class CartouCheckCartem extends ModelCheckerTemplateForward<CartouInfo, CartemInfo> {
	
	public CartouCheckCartem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CartemInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartemCheckExistUser(option);
	}
	
	
	
	@Override protected CartemInfo toForwardClass(CartouInfo baseRecord) {
		return CartemInfo.copyFrom(baseRecord);
	}
}
