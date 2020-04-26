package br.com.mind5.business.cart.model.checker;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cartItemSearch.info.CartemarchCopier;
import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.checker.CartemarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartCheckCartemarch extends ModelCheckerTemplateForwardV2<CartInfo, CartemarchInfo> {
	
	public CartCheckCartemarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CartemarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartemarchCheckExist(option);
	}
	
	
	
	@Override protected CartemarchInfo toForwardClass(CartInfo baseRecord) {
		return CartemarchCopier.copyFromCartKey(baseRecord);
	}
}
