package br.com.mind5.business.cart.model.checker;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartCheckOwner extends ModelCheckerTemplateForward<CartInfo, OwnerInfo> {
	
	public CartCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CartInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
