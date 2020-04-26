package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.checker.CartCheckExist;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckCart extends ModelCheckerTemplateForwardV2<CartemInfo, CartInfo> {
	
	public CartemCheckCart(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CartInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartCheckExist(option);
	}
	
	
	
	@Override protected CartInfo toForwardClass(CartemInfo baseRecord) {
		return CartInfo.copyFrom(baseRecord);
	}
}
