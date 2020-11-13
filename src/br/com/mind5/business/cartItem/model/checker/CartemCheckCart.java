package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.checker.CartCheckExist;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckCart extends ModelCheckerTemplateForward<CartemInfo, CartInfo> {
	
	public CartemCheckCart(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CartInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartCheckExist(option);
	}
	
	
	
	@Override protected CartInfo toForwardClass(CartemInfo baseRecord) {
		return CartInfo.copyFrom(baseRecord);
	}
}
